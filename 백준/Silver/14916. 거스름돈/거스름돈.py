# Greedy
import sys
n = int(sys.stdin.readline())

# 거스름돈을 줄 수 없는 경우
if n in [1,3]:
    print(-1)
    exit()

# 5원짜리 동전의 개수 N
# 2원짜리 동전의 개수 M

# 거스름돈을 줄 수 있는 경우
# 1) 5원짜리를 최대한 많이 주는 경우
N = n//5
M = (n-N*5)//2
if (n-N*5) % 2 == 0:
    print(N + M)
    exit(0)

# 2) 5원짜리를 최대한 많이 주는 것보다 1개 적게 주고 나머지를 2원짜리로 주는 경우
N = n//5-1
if N>0:
    n -= N * 5
M = n//2
print(N + M)