import sys
N = int(sys.stdin.readline())
hStack = []

for _ in range(N):
    h = int(sys.stdin.readline().rstrip())
    if len(hStack) == 0: # 스택이 비어있다면 push()
        hStack.append(h)
    else: # 스택이 비어있지 않다면
        if hStack[-1] > h: # 스택 top이 h보다 큼 -> 입력값에 push()
            hStack.append(h)
        else: # 스택 top이 h보다 작은 경우
            while(True): # 스택이 비거나 스택 top이 h보다 큰 값이 나올 때까지 pop()
                if len(hStack) == 0:
                    break
                elif hStack[-1] > h:
                    break
                hStack.pop() 
            hStack.append(h) # 모든 pop()이 끝나고 나면 h를 push()

print(len(hStack)) # 스택의 길이 출력

'''
Stack

1. 스택 탑과 입력값 비교
    탑 > 입력값 -> 입력값 push
    탑 <= 입력값 -> 스택이 empty하거나 더 큰 값이 나올 때까지 pop()

2. 입력이 끝나면 스택의 길이 출력
'''