from collections import deque

N, K = map(int, input().split())
section_durability = deque(list(map(int, input().split())))
section_robot = deque([0] * N)
step = 0

while True:
    # 0. 단계 증가
    step += 1

    # 1. 벨트가 한 칸 회전한다
    section_durability.rotate(1)
    section_robot.rotate(1)

    # 1-1. 내리는 위치에 있는 로봇을 내린다
    section_robot[N-1] = 0

    # 2. 로봇이 벨트 회전 방향으로 한 칸씩 이동한다
    for i in range(N-2, -1, -1):
        if section_robot[i] == 1 and section_robot[i+1] == 0 and section_durability[i+1] > 0:
            section_robot[i] = 0
            section_robot[i+1] = 1
            section_durability[i+1] -= 1

    # 2-1. 내리는 위치에 있는 로봇을 내린다
    section_robot[N-1] = 0

    # 3. 올리는 위치에 로봇을 올린다
    if section_durability[0] > 0:
        section_robot[0] = 1
        section_durability[0] -= 1

    # 4. 내구도가 0인 칸의 개수가 K개 이상인지 체크한다
    if section_durability.count(0) >= K:
        break

print(step)