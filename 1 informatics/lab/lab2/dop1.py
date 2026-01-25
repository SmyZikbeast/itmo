def print_i(message):
    res=''
    for i in [2,4,5,6]:
        res+=message[i]
    return res
def not_bit(x):
    return '0' if x == '1' else '1'
s=input()
if len(s)==7:
    s1=sum(int(s[x]) for x in [0,2,4,6])%2
    s2=sum(int(s[x]) for x in [1,2,5,6])%2
    s3=sum(int(s[x]) for x in [3,4,5,6])%2
    wrong_bit=int(str(s3)+str(s2)+str(s1),2)
    if wrong_bit==0:
        print(f'Message was correct')
    else:
        print(f'Error in bit {wrong_bit}')
        s = ''.join(
    [not_bit(s[i]) if i == wrong_bit - 1 else s[i] for i in range(len(s))]
        )
    print(print_i(s))
else:
    print('Wrong length!')
