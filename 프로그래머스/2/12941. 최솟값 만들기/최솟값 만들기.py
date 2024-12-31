def solution(A,B):
    A = sorted(A)
    B = sorted(B, reverse = True)
    ans = 0
    for i in range(len(A)):
        ans += A[i] * B[i]
    return ans