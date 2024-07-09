import sys

N = int(sys.stdin.readline())
arr = list(map(int, sys.stdin.readline().split()))
dp = [1]*N

for i in range(1, N):
    for j in range(i):
        if arr[i]>arr[j]:
            dp[i] = max(dp[i], dp[j]+1)
print(max(dp))

'''
최장 증가 부분 수열(LIS) 알고리즘

<방법 1> - DP를 이용
1. 주어진 배열에서 인덱스(k)를 한 칸씩 늘리면서 확인
2. 내부 반복문으로 k보다 작은 인덱스를 살펴보면서 arr[i]<arr[k]인 것이 있을 경우 
    length[k]를 업데이트
    [업데이트 기준]
    1) i번째 인덱스에서 끝나는 최장 증가 부분 수열의 마지막에 arr[k]를 추가했을 때의 LIS 길이
    2) 추가하지 않고 기존의 length[k] 값
    -> 둘 중에 더 큰 값으로 length[k] 값을 업데이트
3. 전체 length에서 가장 큰 값을 출력
-> 이 방법의 시간복잡도는 O(n^2)


<방법 2> - 이분탐색을 이용
주어진 배열의 인덱스를 하나씩 살펴보면서 그 숫자가 들어갈 위치를 이분탐색으로 탐색
-> 이 방법의 시간복잡도는 O(n log n)

1. arr과 lis 배열을 각각 정의
2. arr의 첫번째 인덱스 값을 lis에 삽입 (k=1)
3. arr의 두번째 값을 lis[k]와 비교 
    -> 작은 경우 lis[k]에 삽입
    -> 큰 경우 lis[k+1에 삽입
4. n까지 반복한 후 k값을 출력하면 답

'''