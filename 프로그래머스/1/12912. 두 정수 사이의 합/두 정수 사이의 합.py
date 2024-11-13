def solution(a, b):
    low, high = 0, 0
    if a<b:
        low = a
        high = b
    elif a>b:
        low = b
        high = a
    else:
        return a
    
    answer = 0
    for i in range(low, high+1):
        answer += i
    return answer