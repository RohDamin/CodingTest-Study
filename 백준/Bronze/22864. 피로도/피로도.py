# Greedy
import sys
A, B, C, M = map(int, sys.stdin.readline().split())
if (A>M):
    print(0)
    exit(0)

time = 0
work = 0
hp = 0

while time<24:
    if hp+A<=M:
        hp += A
        work += B
    else:
        hp -= C
        if hp<0:
            hp = 0
    time += 1
print(work)