import sys
N = int(sys.stdin.readline())
hStack = []

for _ in range(N):
    h = int(sys.stdin.readline().rstrip())
    if len(hStack) == 0:
        hStack.append(h)
    else:
        if hStack[-1] > h:
            hStack.append(h)
        else:
            while(True):
                if len(hStack) == 0:
                    break
                elif hStack[-1] > h:
                    break
                hStack.pop()
            hStack.append(h)

print(len(hStack))