import sys


def factorial(num):
    if (num <=1):
        return 1
    else:
        return num*factorial(num-1)


n, a, b, c = map(int, sys.stdin.readline().split())
print(factorial(n)//(factorial(a)*factorial(b)*factorial(c)))