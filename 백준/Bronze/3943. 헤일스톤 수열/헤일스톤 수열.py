import sys

n = int(sys.stdin.readline())

for i in range(n):
    number = int(sys.stdin.readline())
    numList = []
    while(True):
        numList.append(number)
        if number != 1:
            if number % 2 == 0: # 짝수
                number //= 2
            else:
                number = number * 3 + 1
        else:
            print(max(numList))
            break