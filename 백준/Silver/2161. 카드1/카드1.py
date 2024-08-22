import sys
from collections import deque

n = int(sys.stdin.readline())
q = deque()
result = deque()

for i in range(1, n+1):
    q.append(i)

i = 1
while(len(q) > 1):
    if i%2 == 1: # 카드를 버린다
        result.append(q.popleft())
    else: # 큐의 카드를 맨 뒤로 옮긴다
        q.append(q.popleft())
    i+=1
result.append(q.popleft())
print(*result)
