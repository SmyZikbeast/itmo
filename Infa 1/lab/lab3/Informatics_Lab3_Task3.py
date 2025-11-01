# Author = Bashlachyov Alexander Pavlovich
# Group = P3131
# Date = 29.10.2025

from re import *

isu = 502792
print('var number:', str(isu%3))

example1=2-1
example='Футбольный клуб «Реал Мадрид» является 15-кратным обладателем главного футбольного европейского трофея – Лиги Чемпионов. Данный турнир организован Союзом европейских футбольных ассоциаций (УЕФА). Идея о континентальном футбольном турнире пришла к журналисту Габриэлю Ано в 1955 году.'

list_ends_2 = ["ый", "ий", "ой", "ая", "яя", "ое", "ее", "ые", "ии", "ей", "ую", "юю", "ом", "ем", "ых", "их", "ие"]
list_ends_3 = ["ьий", "ого", "его", "ому", "ему", "ыми", "ими"]
list_ends_4 = ["ские"]

for word in example.split():
    list_words=[]
    if word[-4:] in list_ends_4: #проверка на прилагательное c 4-окончанием
        pattern = rf'{word[:-4].lower()}[а-яё]+'
        list_words=[x.group() for x in finditer(pattern,example.lower())]
        if len(list_words)>1:
            example = sub(pattern, list_words[example1], example, flags = IGNORECASE)
    elif word[-3:] in list_ends_3: #проверка на прилагательное с 3-окончанием
        pattern = rf'{word[:-3].lower()}[а-яё]+'
        list_words=[x.group() for x in finditer(pattern,example.lower())]
        if len(list_words)>1:
            example = sub(pattern, list_words[example1], example, flags = IGNORECASE)
    elif word[-2:] in list_ends_2: #проверка на прилагательное с 2-окончанием
        pattern = rf'{word[:-2].lower()}[а-яё]+'
        list_words=[x.group() for x in finditer(pattern,example.lower())]
        if len(list_words)>1:
            example = sub(pattern, list_words[example1], example, flags = IGNORECASE)

print(example)
