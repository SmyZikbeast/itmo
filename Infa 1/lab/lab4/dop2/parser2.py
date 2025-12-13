import pyron
ron_data = open("schedule.ron").read()
print(ron_data)
data = pyron.loads(ron_data)
print(data)
