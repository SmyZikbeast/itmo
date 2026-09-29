    .data

input_addr:      .word  0x80               ; Input address where the number 'n' is stored
output_addr:     .word  0x84               ; Output address where the result should be stored
n:               .word  0x00               ; Variable to store the number 'n'
const_1:         .word  0x01               ; Constant 1
i:               .word  0x02

    .text
_start:
    load         input_addr
    load_acc
    store        n                         ; mem[n] = acc 
prime_begin:
    sub		 const_1		   ; for comparison
    bltz         lower_than_one            ; negative number
    beqz	 non_prime                 ; number = 1
    sub          const_1
    beqz         prime                     ; number = 2
prime_while:
    load         n
    rem          i
    beqz         non_prime                 ; if rem == 0 then it is not prime
    load         i
    add          const_1
    store        i                         ; incrementing i
    mul          i                         ; acc = i ^ 2
    sub          n
    bltz         prime_while               ; if i ^ 2 <= n then goto loop 
    beqz         prime_while
    jmp          prime                     ; loop ended -> prime
non_prime:
    load_imm     0
    store_ind    output_addr
    halt
lower_than_one:
    load_imm     -1
    store_ind    output_addr               ; mem[mem[output_addr]] = -1
    halt
prime:
    load_imm     1
    store_ind    output_addr
    halt