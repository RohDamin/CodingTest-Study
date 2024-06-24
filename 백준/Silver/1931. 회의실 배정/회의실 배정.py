import sys
N = int(input())
endPoint: int = 0
ans: int = 0
arr = []

for i in range(N):
    a, b = map(int, sys.stdin.readline().rstrip().split())
    arr.append([a,b])
arr.sort(key=lambda x:(x[1], x[0]))
for newStart, newEnd in arr:
    if endPoint <= newStart:
        ans+=1
        endPoint = newEnd
print(ans)