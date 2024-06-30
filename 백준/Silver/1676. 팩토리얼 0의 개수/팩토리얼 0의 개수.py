# 수학
import sys
import math
N = int(sys.stdin.readline())
fn = str(math.factorial(N))[::-1]
cnt = 0
for i in range(len(fn)):
    if fn[i]=='0':
        cnt+=1
    else:
        break
print(cnt)
