def solution(arr):
    min_num = min(arr)
    arr.remove(min_num)
    if len(arr) == 0:
        return [-1]
    return arr