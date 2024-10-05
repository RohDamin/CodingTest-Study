while True:
    lst = []
    N = input()
    if N == '0':
        break
    for i in N:
        lst.append(i)
    totallen = 0
    for i in lst:
        totallen += 1
        if i == '0':
            totallen += 4
        elif i == '1':
            totallen += 2
        else:
            totallen += 3
    totallen += 1
    print(totallen)