import sys

arr = [[0 for i in range(101)] for j in range(101)]
for k in range(4):
    dx, dy, ux, uy = map(int, sys.stdin.readline().split())
    for i in range(dx, ux):
        for j in range(dy, uy):
            arr[i][j] = 1

cnt = 0
for i in range(101):
    for j in range(101):
        cnt += arr[i][j]
print(cnt)

