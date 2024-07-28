import sys

score = [int(sys.stdin.readline()) for _ in range(8)]
res = sorted(score)[3:]
temp = []
for i in res:
    temp.append(score.index(i) + 1)
print(sum(res))
print(*sorted(temp))
