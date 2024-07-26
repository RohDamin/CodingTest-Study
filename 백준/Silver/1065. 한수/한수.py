import sys


def hansu(N):
    hansuCnt = 0
    for i in range(1, N+1):
        numList = list(map(int, str(i)))
        if i<100:
            hansuCnt+=1
        elif numList[0]-numList[1] == numList[1]-numList[2]:
            hansuCnt+=1
    return hansuCnt


print(hansu(int(sys.stdin.readline())))
