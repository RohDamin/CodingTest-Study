def solution(nums):
    cnt = 0
    pkms = set(nums)
            
    if (len(nums)//2 > len(pkms)): # 기존 배열길이/2가 pkms 길이보다 크다면
        cnt = len(pkms)
    else:
        cnt = len(nums)//2
        
    return cnt