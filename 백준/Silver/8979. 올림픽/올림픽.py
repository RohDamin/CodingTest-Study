import sys
n, k = map(int, sys.stdin.readline().split())
lst = [list(map(int, sys.stdin.readline().split())) for i in range(n)]
lst.sort(key=lambda x: (-x[1], -x[2], -x[3]))
idx = [lst[i][0] for i in range(n)].index(k)

for i in range(n):
    if lst[idx][1:] == lst[i][1:]:
        print(i+1)
        exit(0)