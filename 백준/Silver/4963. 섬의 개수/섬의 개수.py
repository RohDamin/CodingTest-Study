import sys
from collections import deque

def BFS(arr, visited, x, y):
    dy = [1, 1, 1, 0, 0, -1, -1, -1]
    dx = [-1, 0, 1, -1, 1, -1, 0, 1]

    q = deque()
    q.appendleft((x, y))

    while(len(q) != 0):
        now = q.pop()
        nowX = now[0]
        nowY = now[1]

        for i in range(8):
            nx = nowX + dx[i]
            ny = nowY + dy[i]

            if (isRange(nx, ny, len(arr), len(arr[0])) and arr[nx][ny] == 1 and not visited[nx][ny]):
                q.appendleft((nx, ny))
                visited[nx][ny] = True


def isRange(x, y, w, h):
    return y>=0 and x>=0 and y<h and x<w


while(True):
    w, h = map(int, sys.stdin.readline().split())
    if w==0 and h==0:
        break
    island = [list(map(int, sys.stdin.readline().split())) for _ in range(h)]
    visited = [[False for _ in range(w)] for _ in range(h)]
    # print(island)
    # print(visited)
    islandCnt = 0

    for i in range(h):
        for j in range(w):
            if island[i][j] == 1 and not visited[i][j]:
                BFS(island, visited, i, j)
                islandCnt+=1
    print(islandCnt)