def solution(n):
    str_n = str(n)
    res = 0
    for i in range(0, len(str(n))):
        res += int(str_n[i])
    return res