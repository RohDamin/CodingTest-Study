from heapq import heappush, heappop, heapify


def solution(scoville, K):
    heapify(scoville) # scoville 배열을 heapq로 변환
    cnt = 0
    
    while True:
        # 모든 음식의 스코빌 횟수가 7 이상인지 확인
        first = heappop(scoville)
        if (first >= K):
            return cnt
        else:
            heappush(scoville, first)
    
        if (len(scoville) >= 2):
            heappush(scoville, heappop(scoville) + heappop(scoville)*2)
            cnt +=1
        else: 
            break;

    return -1