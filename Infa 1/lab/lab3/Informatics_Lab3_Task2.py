# Author = Bashlachyov Alexander Pavlovich
# Group = P3131
# Date = 29.10.2025

from re import *

def func(x):
    if x[-2]=='.':
        x=x[:-2]
    return ' h'+str(5*int(x)**3-13)+' '

isu = 502792
print('var number:', str(isu%5))

integer = r'(([ ]|^)([1-9][0-9]*)([ ]|$|([.][ ])))'
example='12354376 + 645.34556 = 234 31254 412'
example2 = "В магазине было 12 товаров, а потом пришли 7 покупателей."
example3 = "Текст без чисел"
example4 = "Общее количество участников: 25. Еще пришло 122 человека."
example = example4
example = sub(integer, lambda m: func(m.group()), example)
example = sub(integer, lambda m: func(m.group()), example)

print(example.strip().replace('h',''))

