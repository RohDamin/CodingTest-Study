cnt = int(input())
nums = list(map(int, input().split()))
max = nums[0]
min = nums[0]
for i in nums[1:]:
    if i > max:
        max = i
    if i < min:
        min = i
print(min, max)