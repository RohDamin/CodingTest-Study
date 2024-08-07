def solution(nums):
    cnt = 0
    pkms = []
    for pkm in nums:
        if pkm not in pkms:
            pkms.append(pkm)
            
    if (len(nums)//2 > len(pkms)): # 기존 배열길이/2가 pkms 길이보다 크다면
        cnt = len(pkms)
    else:
        cnt = len(nums)//2
        
    return cnt