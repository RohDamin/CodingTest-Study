import sys
N = int(sys.stdin.readline())
for i in range(N):
    words = list(sys.stdin.readline().split())
    words.reverse()
    print("Case #" + str(i+1) + ": " + ' '.join(words))
