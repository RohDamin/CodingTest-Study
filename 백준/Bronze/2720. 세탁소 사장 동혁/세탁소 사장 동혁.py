n = int(input())
for _ in range(n):
    coin = int(input())
    for i in [25, 10, 5, 1]:
        print(coin//i, end=' ')
        coin = coin%i