from collections import deque

n, w, L = map(int, input().split())
trucks = deque(list(map(int, input().split())))
bridge = deque([0] * w)
bridge_w = 0
t = 0

while True:
    # print("time: ", t)
    # print("bridge: ", bridge)
    # print("trucks: ", trucks)

    # 모든 트럭이 지나갔는지 확인
    if bridge_w == 0 and len(trucks) == 0:
        break

    # 다리 맨 앞의 트럭 제거
    # 다리 위의 트럭 무게 합 업데이트
    if len(bridge) != 0:
        out_truck = bridge.popleft()
        bridge_w -= out_truck

    # 새로운 트럭이 올라갈 수 있다면 추기
    # 다리 위의 트럭 무게 합 업데이트
    if len(trucks) != 0 and bridge_w + trucks[0] <= L:
        in_truck = trucks.popleft()
        bridge.append(in_truck)
        bridge_w += in_truck
    else:
        bridge.append(0)  # 다리의 길이 유지

    # 시간 증가
    t += 1

print(t)