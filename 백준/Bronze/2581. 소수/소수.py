import sys


def isPrime(num):
    if num == 1:
        return False
    if num == 2:
        return True
    for i in range(2, num):
        if num % i == 0:
            return False
    return True


M = int(sys.stdin.readline())
N = int(sys.stdin.readline())
sum = 0
minNum = 10001
for i in range(M, N + 1):
    if isPrime(i):
        sum += i
        minNum = min(minNum, i)
if sum == 0:
    print(-1)
else:
    print(sum)
    print(minNum)
