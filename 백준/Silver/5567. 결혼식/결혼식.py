from collections import defaultdict, deque

n = int(input())
m = int(input())

# 그래프 생성
graph = defaultdict(list)
for _ in range(m):
    u, v = map(int, input().split())
    graph[u].append(v)
    graph[v].append(u)

# 깊이 2까지만 탐색 (친구, 친구의 친구)
def BFS(start, max_depth):
    queue = deque([(start, 0)])
    visited = set([start])

    while queue:
        node, depth = queue.popleft()
        if depth == max_depth:
            continue
        for nextNode in graph[node]:
            if nextNode not in visited:
                queue.append((nextNode, depth+1))
                visited.add(nextNode)
    print(len(visited) - 1) # 상근 제외

BFS(1, 2)