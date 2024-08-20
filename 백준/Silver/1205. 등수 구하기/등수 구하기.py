import sys

n, s, p = map(int, sys.stdin.readline().split())
score = list(map(int, sys.stdin.readline().split()))

if n == 0:
    print(1)
    exit(0)

if n == p and score[-1] >= s:
    print(-1)
else:
    rank = n + 1
    for i in range(n):
        if score[i] <= s:
            rank = i + 1
            break
    print(rank)