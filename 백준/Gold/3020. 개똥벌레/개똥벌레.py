import sys

N, H = map(int, sys.stdin.readline().split())
cave_up = []
cave_down =[]

for i in range(1, N+1):
    h = int(sys.stdin.readline())
    if i%2 == 0: # i가 짝수인 경우(종유석)
        cave_down.append(h)
    else: # i가 홀수인 경우(석순)
        cave_up.append(h)

cave_up.sort()
cave_down.sort()

def binary_search(arr,target, start, end):
    while start <= end:
        mid = (start + end)//2

        if arr[mid] < target:
            start = mid+1
        else:
            end = mid-1
    return start

minCnt= N
rangeCnt = 0

for i in range(1, H+1):
    downCnt = len(cave_down) - binary_search(cave_down, i-0.5, 0, len(cave_down)-1)
    upCnt = len(cave_up) - binary_search(cave_up, H-i+0.5, 0, len(cave_down)-1)
    if minCnt == downCnt + upCnt:
        rangeCnt += 1
    elif minCnt > downCnt + upCnt:
        rangeCnt = 1
        minCnt = downCnt + upCnt
print(minCnt, rangeCnt)