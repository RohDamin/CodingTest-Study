import sys

n = sys.stdin.readline().strip()
nums = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
cnt = 1

for i in range(len(n)):
    if int(n[i]) not in nums: # 이미 사용한 경우
        if int(n[i]) == 6: # 6인 경우
            if 9 in nums: # 9가 있다면 9를 제거
                nums.remove(9)
                continue

        elif int(n[i]) == 9:
            if 6 in nums:
                nums.remove(6)
                continue

        cnt += 1
        nums.extend(range(10))
        nums.remove(int(n[i]))

    else: # 사용하지 않은 경우
        nums.remove(int(n[i]))
        
print(cnt)