import sys
N = int(sys.stdin.readline())
dict = {}
for i in range(N):
    title = sys.stdin.readline().rstrip()
    if title in dict:
        dict[title]+=1
    else:
        dict[title] = 1

# 가장 많이 팔린 책이 여러 개일 경우에는 사전 순으로 가장 앞서는 제목을 출력
best = []
best_value = max(dict.values())
for key, value in dict.items():
    if value == best_value:
        best.append(key)
best.sort()
print(best[0])
