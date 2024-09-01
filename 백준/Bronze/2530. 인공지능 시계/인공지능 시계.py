import sys

h, m, s = map(int,sys.stdin.readline().split())
t = int(sys.stdin.readline())

s += t
m += s//60
h += m//60
print(h % 24, m % 60, s % 60)