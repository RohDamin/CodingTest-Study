def solution(s):
    answer = []
    ans = 0
    cnt = 0
    
    while s != '1':
        cnt += 1
        
        # 1번 단계
        ans += s.count('0')
        s = s.replace('0', '')
                
        # 2번 단계
        s = format(len(s), 'b')
    
    answer.append(cnt)
    answer.append(ans)

    return answer