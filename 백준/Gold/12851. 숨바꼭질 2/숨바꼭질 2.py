import sys
from collections import deque


def BFS(N, K, minTime):
    q = deque()
    visited = [0] * 100001
    q.appendleft([N, 0])  # 수빈이의 현재 위치, 경과 시간
    minTimeCnt = 0

    while (len(q) != 0):
        now = q.pop()
        visited[now[0]] = 1
        if now[0] == K:
            if minTime > now[1]:
                minTime = now[1]
                minTimeCnt = 1
            elif minTime == now[1]:
                minTimeCnt += 1
            else:
                break
            # print(minTime, minTimeCnt)
        n1 = now[0] + 1
        n2 = now[0] - 1
        n3 = now[0] * 2
        # print(now)
        if isRange(n1) and visited[n1] != 1:
            q.appendleft([n1, now[1] + 1])
        if isRange(n2) and visited[n2] != 1:
            q.appendleft([n2, now[1] + 1])
        if isRange(n3) and visited[n3] != 1:
            q.appendleft([n3, now[1] + 1])
    return minTime, minTimeCnt


def isRange(n):
    return 0 <= n <= 100000


N, K = map(int, sys.stdin.readline().split())
if (N == K):
    print(0)
    print(1)
    exit()
minTime = sys.maxsize
minTime, minTimeCnt = BFS(N, K, minTime)
print(minTime)
print(minTimeCnt)
