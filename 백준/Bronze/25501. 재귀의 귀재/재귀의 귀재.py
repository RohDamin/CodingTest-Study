N = int(input())

def recursion(s, left, right, cnt):
    cnt += 1
    if left >= right:
        return 1, cnt
    elif s[left] != s[right]:
        return 0, cnt
    else:
        return recursion(s, left+1, right-1, cnt)
def isPalindrome(s):
    cnt = 0
    return recursion(s, 0, len(s)-1, cnt)

for i in range(N):
    print(*isPalindrome(input()))