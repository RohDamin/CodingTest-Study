import sys
N = int(sys.stdin.readline())
people = list(map(int,sys.stdin.readline().split()))
people.sort()

sum = people[0]
waiting = [people[0]]
for i in range(1, N):
    waiting.append(people[i]+waiting[i-1])
for i in range(1, N):
    sum += waiting[i]
print(sum)
