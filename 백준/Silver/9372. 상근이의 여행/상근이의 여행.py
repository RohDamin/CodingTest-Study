import sys

T = int(sys.stdin.readline())

for _ in range(T):
    country, airplane = map(int, sys.stdin.readline().split())
    for _ in range(airplane):
        c, a = map(int, sys.stdin.readline().split())
    print(country - 1)