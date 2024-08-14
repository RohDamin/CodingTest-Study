n = int(input())
start, end = input().split('*')

for _ in range(n) :
    s = input()

    startTemp = s[len(start): ]
    endTemp = startTemp[-len(end):]
    startTemp = s[0: len(start)]

    if startTemp == start and endTemp == end :
        print("DA")
    else :
        print("NE")