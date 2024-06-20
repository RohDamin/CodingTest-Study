#그리디, 문자열
import sys
N = int(input())
words = [(sys.stdin.readline()).rstrip() for _ in range(N)]
words.sort() #길이순으로 단어 정렬
cnt = 0
for i in range(N):
    nTrue = False
    for j in range(i+1, N): #i다음~끝까지 단어 비교
        if words[i] == words[j][0:len(words[i])]:
            nTrue = True
            break #하나라도 같으면 포함될 수 없음
    if not nTrue:
        cnt+=1
print(cnt)
