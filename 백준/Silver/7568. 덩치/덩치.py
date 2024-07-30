import sys

N = int(sys.stdin.readline())
student = []

for _ in range(N):
    w, h = map(int, input().split())
    student.append((w, h))

for i in student:
    cnt = 1
    for j in student:
        if i[0] < j[0] and i[1] < j[1]:
            cnt += 1
    print(cnt, end=" ")