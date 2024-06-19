# 완전탐색
import sys
from itertools import combinations
input = sys.stdin.readline
N, S = map(int, input().split())
numbers = list(map(int, input().split()))
cnt = 0

for i in range(1, N+1):
    comb = combinations(numbers, i)
    for x in comb:
        if sum(x) == S:
            cnt += 1

print(cnt)