import sys
T = int(sys.stdin.readline())
N = 3

for i in range(T):
    arr = list(map(int, sys.stdin.readline().split()))
    arr.sort(reverse=True)
    print(arr[N-1])