import parser
import toml
import time
with open("schedule.ron", encoding="utf-8") as f:
    schedule = f.read()

data = parser.loads(schedule)
print(data)
lines_my = parser.serialize_to_toml(data)
lines_toml = toml.dumps(data)
my_content = '\n'.join(lines_my)
toml_content = lines_toml
print(toml_content)
with open('schedule.toml', 'w', encoding="utf-8") as file:
    file.write(toml_content)
    file.write("----------------------------------------------\n")
    file.write(my_content)
start_time_1 = time.perf_counter()
for i in range(1000):
    data = parser.loads(schedule)
    lines = parser.serialize_to_toml(data)
end_time_1 = time.perf_counter()
time_1 = end_time_1 - start_time_1
start_time_2 = time.perf_counter()
for i in range(1000):
    data = parser.loads(schedule)
    lines = toml.dumps(data)
end_time_2 = time.perf_counter()
time_2 = end_time_2 - start_time_2
print(f"My time: {time_1:.4f}, lib time: {time_2:.4f}")
