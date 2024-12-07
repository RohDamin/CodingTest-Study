def solution(n):
    answer = str(n)
    sorted_answer = ''.join(sorted(answer, reverse=True))
    return int(sorted_answer)