import sys

N = int(sys.stdin.readline())
for _ in range(N):
    clothes = {}
    n = int(sys.stdin.readline().strip())
    for i in range(n):
        name, type = sys.stdin.readline().strip().split()
        if type in clothes:
            clothes[type].append(name)
        else:
            clothes[type] = [name]
    cnt = 1

    for x in clothes:
        cnt *= (len(clothes[x]) + 1)
    print(cnt - 1)
