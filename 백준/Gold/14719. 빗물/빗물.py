H, W = map(int, input().split())
block = list(map(int, input().split()))

sum = 0
for i in range(1, W-1): # 양 끝은 물이 채워질 수 없으므로 제외하고 시작
    left = max(block[:i]) # 0~i번째(i번째 포함X) 인덱스 중에서 max값 구하기
    right = max(block[i+1:]) # i+1~마지막 인덱스 중에서 max값 구하기

    m = min(left, right)
    if m>block[i]:
        sum += m-block[i]
print(sum)
