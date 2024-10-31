lst = list(str(input()))
res = 0
for i in range(len(lst)):
    if i == 0:
        res += 10
    elif lst[i] == lst[i-1]:
        res += 5
    else:
        res += 10  
print(res)