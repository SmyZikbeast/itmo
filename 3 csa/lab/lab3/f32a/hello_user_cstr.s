	.data
.org 0x20
buf_addr:		.word 0x0
input_addr:		.word 0x80
output_addr:		.word 0x84
question_const:		.byte 'What is your name?\n'
	.text
.org 0x88
_start:
	lit 0
	a!
	lit 72
	!+
	lit 101
	!+
	lit 108
	!+
	lit 108
	!+
	lit 111
	!+
	lit 44
	!+
	lit 32
	!+
	lit question_const\ question address in stack
	a!\ question addr in a
	@p output_addr
	b!\ output addr in b
loop1:
	read_a
	dup
	!b
	is_newline
	if answer_begin\ cmp with next line sym
	loop1 ;
\ WROTE QUESTION TO OUTPUT
answer_begin:
	lit 0x7
	a!\ string buffer addr in a
	@p input_addr
	b!
read:
	read_b
	dup
	is_newline
	if ending
	dup
	if clear
	!+
	a
	-30
	+
	if fail
	read ;
clear:
	mask
	@b
	is_newline
	if ending
	clear ;
ending:\buffer contains string start + name
	'!'
	!+
	0
	!+
loop_fill:
	a
	-32
	+
	if write
	lit 0x5f
	!+
	loop_fill ;
write:\buffer contains full string
	lit 0
	a!\ string buffer addr in a
	@p output_addr
	b!\ output port in b
loop4:
	read_a
	dup
	if hlt
	!b
	loop4 ;
fail:
	lit 0xCCCCCCCC
	@p output_addr
	b!\ output port in b
	!b
hlt:
	halt
read_b:
	@b
	mask
	;
read_a:
	@+
	mask
	;
is_newline:
	-10
	+
	;
mask:
	255
	and
	;