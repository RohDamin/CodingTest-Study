lst = []
n = int(input())
for i in range(n):
    lst.append(int(input()))
lst = sorted(lst)
for i in range(n):
    print(lst[i])