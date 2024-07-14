import sys
N, K = map(int, sys.stdin.readline().split())
coins = [int(sys.stdin.readline()) for i in range(N)]
coins.sort(reverse=True)
coinNum = 0
for i in range (N):
    if K >= coins[i]: # K가 동전보다 작거나 같은 경우
        currentK = K
        coinNum += currentK // coins[i]
        K = currentK % coins[i]
print(coinNum)