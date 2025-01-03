def solution(n):
    ans = 0
    for i in range(1, n+1):
        if add(i, n):
            ans += 1
    return ans
        

def add(start_n, n):
    # start_n부터 n까지 더하면서 체크
    sum_n = 0
    for i in range(start_n, n+1):
        sum_n += i
        if sum_n > n:
            return False
        if sum_n == n:
            return True
    