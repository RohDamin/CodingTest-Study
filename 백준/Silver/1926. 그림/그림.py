from collections import deque

dx = [0,0,-1,1]
dy = [1,-1,0,0]

n, m = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(n)]
visited = [[False]*m for _ in range(n)]
maxVal = 0
paintingCnt = 0

def BFS(x, y):
    q = deque()
    q.append((x, y))
    visited[x][y] = True
    global paintingCnt
    paintingCnt+=1
    count = 1

    while q:
        px, py = q.popleft()
        for i in range(4):
            nx = px+dx[i]
            ny = py+dy[i]
            if nx<0 or ny<0 or nx>=n or ny>=m:
                continue
            if graph[nx][ny] == 1 and not visited[nx][ny]:
                q.append((nx, ny))
                visited[nx][ny] = True
                count += 1
    return count

for i in range(n):
    for j in range(m):
        if graph[i][j] == 1 and not visited[i][j]:
            maxVal = max(BFS(i, j), maxVal)

print(paintingCnt)
print(maxVal)