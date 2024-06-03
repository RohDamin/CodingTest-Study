people = 0
max_people = 0
for _ in range(10):
    minus, plus = map(int, input().split())
    people += plus - minus
    max_people = max(people, max_people)
print(max_people)