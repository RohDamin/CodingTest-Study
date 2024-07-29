import sys


def binary_search(arr, target, start, end):
    while(start <= end):
        m = (start + end) // 2

        if target < arr[m]:
            end = m-1
        elif target > arr[m]:
            start = m+1
        elif target == arr[m]:
            return True

    return False # target 찾지 못한 경우 False 리턴


N = int(sys.stdin.readline())
nArr = list(map(int, sys.stdin.readline().split()))
M = int(sys.stdin.readline())
mArr = list(map(int, sys.stdin.readline().split()))

nArr.sort()

res = []
for i in range(M):
    if binary_search(nArr, mArr[i], 0, N-1):
        res.append(1)
    else:
        res.append(0)

print(*res)