import sys
left = list(input())
right = []
for _ in range(int(input())):
    command = list(sys.stdin.readline().split())
    if command[0] == 'P':
        left.append(command[1])
    elif command[0] == 'L' and left: #명령이 L이고 left에 요소가 있는 경우
        right.append(left.pop())
    elif command[0] == 'D' and right:
        left.append(right.pop())
    elif command[0] == 'B' and left:
        left.pop()

ans = left + right[::-1]
print(''.join(ans))