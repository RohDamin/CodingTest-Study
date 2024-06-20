T = int(input())
dx = [0,1,0,-1] # 상, 우, 하, 좌
dy = [1,0,-1,0]
for _ in range(T):
    op = input()
    x, y = 0, 0
    minx, maxx, miny, maxy = 0,0,0,0
    di = 0
    for i in range(len(op)):
        if op[i] == 'F':
            x += dx[di]
            y += dy[di]
        elif op[i] == 'B':
            x -= dx[di]
            y -= dy[di]
        elif op[i] == 'L':
            di += 1
            if di>3:
                di = 0
        elif op[i] == 'R':
            di -= 1
            if di<0:
                di = 3
        minx = min(x, minx)
        miny = min(y, miny)
        maxx = max(x, maxx)
        maxy = max(y, maxy)
    print((maxx-minx) * (maxy-miny))
