.data
input_addr: .word 0x80
output_addr: .word 0x84

.text

_start:
    movea.l input_addr, A5
    movea.l (A5), A5
    movea.l output_addr, A6
    movea.l (A6), A6

    movea.l 0x500, A4      ; input buffer
    movea.l 0x0, A3        ; output buffer
    movea.l 0x400, A1      ; operator stack
    move.b 0, -(A1)        ; stack terminator

    move.l 0, D0
    movea.l 0xA00, A7

    move.l 0x4FF, D0

read:
    move.b (A5), D1
    move.b D1, (A4)+
    add.l 1, D0

    cmp.l 0x53F, D0
    beq overflow

    cmp.b 10, D1
    bne read

    ; D0 points to LF
    move.l D0, D5

    ; Reset parser to the beginning of the input
    movea.l 0x500, A4
    move.l 0x4FF, D0

    jmp loop1

.org 0x88

loop1:
    move.b (A4)+, D2
    add.l 1, D0            ; D0 = address of the current character

check_whitespace:
    cmp.b 10, D2
    beq loop2

    cmp.b 0x20, D2
    beq loop_exit1

check_number:
    cmp.b '0', D2
    blt check_oper

    cmp.b '9', D2
    bgt check_oper

    ; D0 points to the first digit
    ; D3 starts one byte before it
    move.l D0, D3
    sub.l 1, D3
    movea.l D0, A2

loop_number:
    move.b (A2)+, D2
    add.l 1, D3            ; D3 = address of the character read

    cmp.b '0', D2
    blt end_loop_number

    cmp.b '9', D2
    bgt end_loop_number

    move.b D2, (A3)+
    jmp loop_number

end_loop_number:
    cmp.b 10, D2
    beq end_number_eof

    move.l D3, D0
    sub.l 1, D0
    movea.l D3, A4

    move.b ' ', (A3)+
    jmp loop_exit1

end_number_eof:
    move.l D5, D0
    move.b ' ', (A3)+
    jmp loop2

check_oper:
    cmp.b '+', D2
    beq save_oper

    cmp.b '-', D2
    beq save_oper

    cmp.b '*', D2
    beq save_oper

    cmp.b '/', D2
    beq save_oper

    jmp check_left

save_oper:
    move.b D2, D4         ; save the current operator

loop_oper:
    move.b (A1), D1       ; peek at the operator stack

    cmp.b 0, D1
    beq loop_oper_exit

    cmp.b '(', D1
    beq loop_oper_exit
    move.b D4, D2
    
    jsr check_priorities
    cmp.l D7, D6
    bgt loop_oper_exit

    move.b (A1)+, (A3)+
    move.b ' ', (A3)+

    jmp loop_oper

loop_oper_exit:
    move.b D4, -(A1)      ; push current operator
    jmp loop_exit1

check_left:
    cmp.b '(', D2
    bne check_right

    move.b D2, -(A1)
    jmp loop_exit1

check_right:
    cmp.b ')', D2
    bne error

    jmp loop_right

loop_right:
    move.b (A1), D3

    cmp.b 0, D3
    beq error

    cmp.b '(', D3
    beq loop_right_exit

    move.b (A1)+, (A3)+
    move.b ' ', (A3)+

    jmp loop_right

loop_right_exit:
    move.b (A1)+, D3
    jmp loop_exit1

loop_exit1:
    ; D0 is an address, so compare addresses
    cmp.l D5, D0
    beq loop2

    jmp loop1

loop2:
    move.b (A1)+, D3     ; pop operator

    cmp.b 0, D3
    beq loop_exit2

    cmp.b '(', D3
    beq error

    move.b D3, (A3)+
    move.b ' ', (A3)+

    jmp loop2

loop_exit2:
    ; Replace the final output space with a null terminator.
    cmp.l 0x500, D5
    beq stop
    move.b 0, -(A3)

    movea.l 0x0, A4
    jmp success

overflow:
    movea.l 0x84, A0
    move.l 0xCCCCCCCC, (A0)
    jmp stop

error:
    movea.l 0x84, A0
    move.l 0xFFFFFFFF, (A0)
    jmp stop
    
success:
    move.b (A4)+, D3

    cmp.b 0, D3
    beq stop

    move.b D3, (A6)
    jmp success

stop:
    halt

check_priorities:
    ; D4 = curr operator
    ; D1 = stack operator

    move.b D4, D2
    jsr check_priority
    move.l D7, D6          ; curr oper priority

    move.b D1, D2
    jsr check_priority     ; stack oper priority

    rts

check_priority:
    cmp.b '+', D2
    beq priority_one

    cmp.b '-', D2
    beq priority_one

    cmp.b '*', D2
    beq priority_two

    cmp.b '/', D2
    beq priority_two

priority_one:
    move.l 1, D7
    jmp priority_return

priority_two:
    move.l 2, D7

priority_return:
    rts