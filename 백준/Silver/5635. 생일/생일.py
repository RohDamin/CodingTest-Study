import sys

N = int(sys.stdin.readline())

list = []

for i in range(N):
    name, dd, mm, yy = input().rstrip().split()
    dd, mm, yy = map(int, (dd, mm, yy))
    list.append((yy, mm, dd, name))
list.sort()

print(list[-1][3])
print(list[0][3])