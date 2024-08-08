import sys

N = int(sys.stdin.readline())
arr = set(list(map(int, sys.stdin.readline().split())))
print(N - len(arr))