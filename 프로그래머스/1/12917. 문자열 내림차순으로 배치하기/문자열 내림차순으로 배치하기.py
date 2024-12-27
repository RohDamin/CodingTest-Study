def solution(s):
    s = sorted(list(s), reverse=True)
    print(s)
    return ''.join(s)