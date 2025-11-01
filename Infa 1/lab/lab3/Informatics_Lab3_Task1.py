# Author = Bashlachyov Alexander Pavlovich
# Group = P3131
# Date = 29.10.2025

from re import *

isu = 502792
print('var number:', str(isu%7))
example = 'Студент Вася вспомнил, что на своей лекции Балакшин П.В. упоминал про старшекурсников, которые будут ему помогать: Анищенко А.А., Машина Е.А. и Голованова-Иванова Д.В., Зверюган С.С.'
example2 = 'В списке участников есть Иванов И.В., Петров П.П., а также Королёва К.Ю. и Левченко И.И.'
example3 = "Иванов И.И. и Петрова А.А., а также Тиньков-Тиньков П.П."
example4 = "В тексте есть фамилии: Смирнов М.М., и Кузнецова Е. Ю. а также Лебедев В.В."
example5 = "Обратите внимание на фамилии: Графов Г.Г., Карпов-Карпов Р.Р., и Иванова А.А."
full_name = r'(([А-ЯЁ][а-яё]+(-[А-ЯЁ][а-яё]+)?) [А-ЯЁ][.][А-ЯЁ][.])'
surnames_list = [x[1] for x in findall(full_name,example)]
#surnames_list = [x.group()[:-5] for x in finditer(full_name,example)]
for surname in surnames_list:
    print(surname)
