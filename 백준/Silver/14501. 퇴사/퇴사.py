import sys
N = int(sys.stdin.readline())
consulting = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]
dp = [0] * (N+1)
for i in range(N-1, -1, -1):
    if i + consulting[i][0] <= N: # 상담 가능한 경우
        t = consulting[i][0]
        p = consulting[i][1]
        # dp[i] = p + dp[i+t]
        dp[i] = max(dp[i+1], p+max(dp[i+t:]))
    else :  # 상담 불가능한 경우
        dp[i] = 0
print(max(dp))