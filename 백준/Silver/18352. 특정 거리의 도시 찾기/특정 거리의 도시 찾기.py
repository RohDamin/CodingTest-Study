import sys
from collections import deque


def BFS(start):
    while(q):
        now = q.popleft()

        for i in graph[now]:
            if not visited[i]:
                q.append(i)
                visited[i] = True
                distance[i] = distance[now]+ 1



n, m, k, x = map(int, sys.stdin.readline().split())
graph = [[] for _ in range(n+1)]
for i in range(m):
    a, b = map(int, sys.stdin.readline().split())
    graph[a].append(b)

distance = [0 for _ in range(n+1)]
visited = [False for _ in range(n+1)]
q = deque([x])
visited[x] = True

BFS(x)
cnt = 0
for i in range(1, n+1):
    if distance[i] == k:
        print(i)
        cnt += 1
if cnt == 0:
    print(-1)