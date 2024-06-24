# Greedy
import sys
N, K = map(int, sys.stdin.readline().split())
heights = list(map(int, sys.stdin.readline().split()))
heights.sort()
gaps = []
for i in range(len(heights)-1):
    gaps.append(heights[i+1]-heights[i])
gaps.sort()
# 가장 작은 N-K 간격의 합 계산
# heights를 K 그룹으로 분할하려면 가장 큰 간격을 제거해야 함
if K>1:
    print(sum(gaps[:-(K-1)]))
else:
    print(sum(gaps))
