import sys
A, B = map(int, sys.stdin.readline().split())
problem = []
num = 1
maxNum = 1001
while(maxNum >= 0):
    for j in range(num):
        problem.append(num)
        maxNum -= 1
    num+=1

sum = 0
for i in range(A-1, B):
    sum += problem[i]
print(sum)