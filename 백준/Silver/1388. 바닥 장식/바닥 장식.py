import sys


def DFS(x, y):
    if decoration[x][y] == '-':
        decoration[x][y] = '.'
        for _y in [-1, 1]:
            Y = _y + y
            if Y>0 and Y<m and decoration[x][Y] == '-':
                DFS(x, Y)
    if decoration[x][y] == '|':
        decoration[x][y] = '.'
        for _x in [1, -1]:
            X = _x + x
            if X>0 and X<n and decoration[X][y] == '|':
                DFS(X, y)


n, m = map(int, sys.stdin.readline().split())
decoration = [list(sys.stdin.readline()) for _ in range(n)]

cnt = 0

for i in range(n):
    for j in range(m):
        if decoration[i][j] == '-' or decoration[i][j] == '|':
            DFS(i, j)
            cnt += 1
print(cnt)

