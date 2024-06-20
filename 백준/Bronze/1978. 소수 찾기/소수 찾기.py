N = int(input())
numbers = list(map(int, input().split()))
cnt = 0
for num in numbers:
    if num == 1:
        continue
    for x in range(2, num):
        if (num%x == 0):
            break
    else:
        cnt+=1
print(cnt)
