import sys
from collections import deque

m, n, h = map(int, sys.stdin.readline().split()) # 가로, 세로, 높이
lst = [[list(map(int, sys.stdin.readline().split())) for _ in range(n)] for _ in range(h)]

dx = [0,0,-1,1,0,0]
dy = [-1,1,0,0,0,0]
dz = [0,0,0,0,-1,1]
q = deque()

def BFS():
    while q:
        z, x, y = q.popleft()

        for i in range(6):
            nx = x+dx[i]
            ny = y+dy[i]
            nz = z+dz[i]

            if nx>=0 and nx<n and ny>=0 and ny<m and nz>=0 and nz<h:
                if lst[nz][nx][ny] == 0:  # 익지 않은 토마토인 경우
                    lst[nz][nx][ny] = lst[z][x][y] + 1
                    q.append((nz,nx,ny))


maxDay = 0
notFinish = False

for i in range(h):
    for j in range(n):
        for k in range(m):
            if lst[i][j][k] == 1:
                q.append((i,j,k)) # 익은 토마토 저장

BFS()

for i in range(h):
    for j in range(n):
        for k in range(m):
            if lst[i][j][k] == 0:
                notFinish = True
            maxDay = max(maxDay, lst[i][j][k])
if notFinish:
    print(-1)
else:
    print(maxDay-1)