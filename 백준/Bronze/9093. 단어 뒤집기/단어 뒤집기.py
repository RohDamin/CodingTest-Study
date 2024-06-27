# 문자열
import sys
T = int(sys.stdin.readline())
for _ in range(T):
    str = list(sys.stdin.readline().split())

    for i in range(len(str)):
        print(str[i][::-1], end=' ')