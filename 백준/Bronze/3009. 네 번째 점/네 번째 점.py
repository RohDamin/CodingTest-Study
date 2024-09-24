x1, y1 = map(int, input().split())
x2, y2 = map(int, input().split())
x3, y3 = map(int, input().split())

rx, ry = 0, 0

if (x1 == x2): rx = x3
if (x2 == x3): rx = x1
if (x1 == x3): rx = x2

if (y1 == y2): ry = y3
if (y2 == y3): ry = y1
if (y1 == y3): ry = y2

print(rx, ry)