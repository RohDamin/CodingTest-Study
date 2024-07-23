import sys
N = int(sys.stdin.readline())
enterFlag = False
gomgomSet = set()
gomgomCnt = 0
cnt = 0
for i in range(N):
    name = sys.stdin.readline().strip()
    if name == "ENTER":
        gomgomCnt += len(gomgomSet)
        gomgomSet.clear()
    else:
        gomgomSet.add(name)
print(gomgomCnt+len(gomgomSet))