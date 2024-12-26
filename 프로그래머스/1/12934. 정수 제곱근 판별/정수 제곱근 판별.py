import math

def solution(n):
    sqrt_check = int(math.sqrt(n))
    if sqrt_check ** 2 == n:
        return (sqrt_check + 1) ** 2
    return -1
