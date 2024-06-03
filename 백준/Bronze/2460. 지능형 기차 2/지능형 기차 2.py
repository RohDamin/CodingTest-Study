people = 0
max = 0
for _ in range(0, 10):
    minus, plus = map(int, input().split())
    people = people - minus + plus
    if people > max:
        max = people
print(max)