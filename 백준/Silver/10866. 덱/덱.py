import sys
from collections import deque

N = int(sys.stdin.readline())
dq = deque()
for i in range(N):
    op = sys.stdin.readline().split()
    if op[0] == "push_front":
        dq.appendleft(op[1])
    elif op[0] == "push_back":
        dq.append(op[1])
    elif op[0] == "pop_front":
        if len(dq) != 0:
            print(dq.popleft())
        else:
            print(-1)
    elif op[0] == "pop_back":
        if len(dq) != 0:
            print(dq.pop())
        else:
            print(-1)
    elif op[0] == "size":
        print(len(dq))
    elif op[0] == "empty":
        if len(dq) != 0:
            print(0)
        else:
            print(1)
    elif op[0] == "front":
        if len(dq) != 0:
            print(dq[0])
        else:
            print(-1)
    elif op[0] == "back":
        if len(dq) != 0:
            print(dq[-1])
        else:
            print(-1)