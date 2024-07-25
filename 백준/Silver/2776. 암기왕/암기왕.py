import sys

def binarySearch(sortArr, n):
    l = 0
    h = len(sortArr)-1
    m = int((l + h) / 2)

    while l<=h: # 만약 l이 h보다 커지면 반복문 종료
        m = (l + h) // 2
        if sortArr[m] > n:  # 찾으려는 수가 중간값보다 작으면
            h = m - 1
        elif sortArr[m] < n:  # 찾으려는 수가 중간값보다 크면
            l = m + 1
        elif sortArr[m] == n:  # 찾으려는 수가 중간값과 같으면
            return True

    return False


T = int(sys.stdin.readline())
for t in range(T):
    # 입력
    len1 = int(sys.stdin.readline())
    memo1 = list(map(int, sys.stdin.readline().split()))
    len2 = int(sys.stdin.readline())
    memo2 = list(map(int, sys.stdin.readline().split()))

    memo1.sort() # 이분탐색을 위해 정렬

    for i in range(len(memo2)):
        if binarySearch(memo1, memo2[i]):
            print(1)
        else:
            print(0)