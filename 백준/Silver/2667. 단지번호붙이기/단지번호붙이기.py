from collections import deque

dx = [0,0,1,-1]
dy = [1,-1,0,0]

def bfs(graph, x, y):
    n = len(graph)
    queue = deque()
    queue.append((x, y))
    graph[x][y] = 0
    cnt = 1
    while queue:
        px, py = queue.popleft()
        for i in range(4):
            nx = px+dx[i]
            ny = py+dy[i]
            if nx<0 or ny<0 or nx>=n or ny>=n:
                continue
            if graph[nx][ny] == 1:
                graph[nx][ny] = 0
                queue.append((nx, ny))
                cnt+=1
    return cnt


N = int(input())
graph = []
for i in range(N):
    graph.append(list(map(int, input())))

cnt =[]
for i in range(N):
    for j in range(N):
        if graph[i][j] == 1:
            cnt.append(bfs(graph, i, j))

cnt.sort()
print(len(cnt))
for i in range(len(cnt)):
    print(cnt[i])