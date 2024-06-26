# Greedy
import sys
N = int(sys.stdin.readline())
coin = [0,0,0,0,0,0]
num = [500, 100, 50, 10, 5, 1]
money = 1000-N

for i in range(6):
    coin[i] = money//num[i]
    money -= coin[i]*num[i]

sum = 0
for i in range(6):
    sum += coin[i]
print(sum)