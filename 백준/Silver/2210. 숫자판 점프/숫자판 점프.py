import sys


def DFS(x, y, moveStr):
    if len(moveStr) >= 6:
        if moveStr not in numbers:
            numbers.append(moveStr)
        return

    if y-1>=0: # 상
        DFS(x, y-1, moveStr + str(numlist[x][y]))
    if y+1<5: # 하
        DFS(x, y+1, moveStr + str(numlist[x][y]))
    if x-1>=0: # 좌
        DFS(x-1, y, moveStr + str(numlist[x][y]))
    if x+1<5: # 우
        DFS(x+1, y, moveStr + str(numlist[x][y]))


numlist = [list(map(int, sys.stdin.readline().split())) for j in range (5)]
numbers = []
cnt = 0

for i in range(5):
    for j in range(5):
        DFS(i, j, "")

print(len(numbers))