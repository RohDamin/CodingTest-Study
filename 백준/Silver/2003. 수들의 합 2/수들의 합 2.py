import sys

n, m = map(int, sys.stdin.readline().split())
list = list(map(int, sys.stdin.readline().split()))
l, r = 0, 1
cnt = 0

while r<=n and l<=r:
    sumlist = list[l:r]
    value = sum(sumlist);

    if value == m:
        cnt += 1
        r+= 1
    elif value < m:
        r+=1
    else:
        l += 1
print(cnt)