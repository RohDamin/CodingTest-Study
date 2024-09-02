import sys

l, p = map(int,sys.stdin.readline().split())
c = l * p
person = list(map(int,sys.stdin.readline().split()))
person = [x - c for x in person]
print(*person)