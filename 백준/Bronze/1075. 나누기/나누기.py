N = input()
M = input()
 
num = int(N[:-2]) * (100)
while (num % int(M)) : 
    num += 1

print(str(num)[-2:])