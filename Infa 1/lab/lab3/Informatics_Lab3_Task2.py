# Author = Bashlachyov Alexander Pavlovich
# Group = P3131
# Date = 29.10.2025

from re import *

def func(x):
    return str(5*int(x)**3-13)

isu = 502792
print('var number:', str(isu%5))

integer = r'(([ ]|^)([1-9][0-9]*)([ ]|$))'
example='12354376 + 645.34556 = 234 432 - 2345345 6345'
while [x for x in finditer(integer,example)]:
    x=[h for h in finditer(integer,example)][0]
    example=example[:x.start()]+f' h{func(x.group())} '+example[x.end():]
print(example.strip().replace('h',''))
    
