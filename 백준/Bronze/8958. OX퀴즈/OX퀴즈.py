import sys
N = int(sys.stdin.readline())
for _ in range (N):
    str = sys.stdin.readline()
    cnt = 0
    sum = 0
    for i in range(len(str)):
        if str[i] == 'O':
            cnt+=1
            sum+=cnt
        else:
            cnt = 0
    print(sum)