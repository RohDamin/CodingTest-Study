import sys

N, M = map(int, sys.stdin.readline().split())
dna = []
dnaStr = ""
for i in range(N):
    dna.append(sys.stdin.readline().strip())

for i in range(M):
    A = T = G =C = 0
    for j in range(N): # 세로로 탐색
        if (dna[j][i] == 'A') : A+=1
        if (dna[j][i] == 'T') : T+=1
        if (dna[j][i] == 'G') : G+=1
        if (dna[j][i] == 'C') : C+=1
    maxDna = max(A, max(T, max(G, C)))
    # 사전순으로 추가
    if maxDna == A:
        dnaStr += 'A'
    elif maxDna == C:
        dnaStr += 'C'
    elif maxDna == G:
        dnaStr += 'G'
    elif maxDna == T:
        dnaStr += 'T'

# Hamming Distance 합을 출력
hammingDisCnt = 0
for i in range(N):
    for j in range(M):
        if dnaStr[j] != dna[i][j]:
            hammingDisCnt+=1

print(dnaStr)
print(hammingDisCnt)