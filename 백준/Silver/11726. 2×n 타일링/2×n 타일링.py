import sys
dp = []
dp.append(0)
dp.append(1)
n = int(sys.stdin.readline())

if n == 1:
    print(dp[n])
    exit()

for i in range(2, n+2):
    dp.append((dp[i-1]+dp[i-2])%10007)
print(dp[n+1])