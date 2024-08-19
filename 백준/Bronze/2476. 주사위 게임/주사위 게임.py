import sys

n = int(sys.stdin.readline())
maxMoney = 0

for i in range(n):
    a, b, c = map(int, sys.stdin.readline().split())
    money = 0
    if (a == b and b == c):
        money = 10000 + a*1000
    elif (a == b or a == c):
        money = 1000 + a * 100
    elif (b == c):
        money = 1000 + b * 100
    else:
        money = max(a, b, c) * 100
    maxMoney = max(maxMoney, money)

print(maxMoney)