import sys

N, M = map(int, sys.stdin.readline().split())
nPerson = set(sys.stdin.readline().strip() for _ in range(N))
mPerson = set(sys.stdin.readline().strip() for _ in range(M))
setPerson = nPerson & mPerson # 두 set의 교집합 구하기

listPerson = list(setPerson) # 리스트로 변환
listPerson.sort() # 사전순으로 정렬

# 출력
print(len(listPerson))
for i in listPerson:
    print(i)