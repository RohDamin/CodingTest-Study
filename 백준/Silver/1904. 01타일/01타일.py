import sys

N = int(sys.stdin.readline())
dp = [0, 1, 2]
if N <= 2:
    print(dp[N])
    exit()

for i in range(3, N+1):
    dp.append((dp[i - 2] + dp[i - 1])%15746)

print(dp[N])