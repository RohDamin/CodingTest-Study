import sys
from collections import deque
input = sys.stdin.readline

def BFS(x, y, color):
    queue = deque()
    queue.append((x, y))
    cnt = 0
    visited[x][y] = True

    while queue:
        x, y = queue.popleft()
        cnt += 1
        for i in range(4):
            nx = x+dx[i]
            ny = y+dy[i]
            if 0 <= nx < M and 0 <= ny < N:
                if grid[nx][ny] == color and not visited[nx][ny]:
                    visited[nx][ny] = True
                    queue.append((nx, ny))
    return cnt

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]
N, M = map(int, input().split())
grid = [list(input()) for _ in range(M)]
visited = [[False]*N for i in range(M)]

white, blue = 0,0
for i in range(M):
    for j in range(N):
        if grid[i][j] == 'W' and not visited[i][j]:
            white += BFS(i, j, 'W') ** 2
        elif grid[i][j] == 'B' and not visited[i][j]:
            blue += BFS(i, j, 'B') ** 2
print(white, blue)