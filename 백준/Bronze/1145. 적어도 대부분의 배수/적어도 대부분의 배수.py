nums = list(map(int, input().split()))
minNum = min(nums)
while True:
    cnt = 0
    for i in nums:
        if minNum % i == 0:
            cnt += 1
    if cnt > 2:
        break
    minNum += 1
print(minNum)