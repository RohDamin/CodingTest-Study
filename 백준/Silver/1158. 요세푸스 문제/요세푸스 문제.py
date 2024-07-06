import sys
from collections import deque

N, B = map(int, sys.stdin.readline().split())
queue = deque([])
res = []

for i in range(1, N+1):
    queue.append(i)

while True:
    if len(queue) == 0:
        break
    for i in range(B):
        if i == B-1:
            res.append(queue.popleft())
        else:
            queue.append(queue.popleft())

print('<', end='')
for i in range(len(res)):
    if i != len(res)-1:
        print(res[i], end=', ')
    else:
        print(res[i], end='')
print('>')