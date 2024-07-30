import sys
from collections import deque

N = int(sys.stdin.readline())
E = int(sys.stdin.readline())

graph = [[] for _ in range (N+1)]
visited = [False] * (N+1)

for i in range(E):
    n1, n2 = map(int, sys.stdin.readline().split())
    graph[n1].append(n2)
    graph[n2].append(n1)

q = deque()
for value in graph[1]:
    q.appendleft(value)
if (len(q) == 0):
    print(0)
    exit()

while(len(q) != 0):
    pNode = q.pop()
    visited[pNode] = True
    for value in graph[pNode]:
        if not visited[value] and value not in q:
            q.appendleft(value)
    # print(pNode, q)
    # print(pNode, visited)

print(visited.count(True)-1) # 1 제외