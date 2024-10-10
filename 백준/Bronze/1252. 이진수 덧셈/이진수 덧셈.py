a, b = map(str, input().split())
a = int(a, 2)
b = int(b, 2)
sum = a+b
print(bin(sum)[2:])