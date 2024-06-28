# 수학
import sys
T = int(sys.stdin.readline())

def gcd(a, b):
    while b>0:
        a, b = b, a%b
    return a

def lcm(a, b):
    return a*b // gcd(a,b)

for i in range(T):
    A, B = map(int, sys.stdin.readline().split())
    print(lcm(A,B))