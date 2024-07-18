import sys

N = int(sys.stdin.readline())
dp = [0, 1]
if N == 1:
    print(1)
    exit()

for i in range(2, N + 2):
    dp.append((dp[i - 2] + dp[i - 1]) % 10007)
print(dp[N + 1])