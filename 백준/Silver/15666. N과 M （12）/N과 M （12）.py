N, M = map(int, input().split())
nums = sorted(set(list(map(int, input().split()))))
res = []
p = []

def solve(depth, idx):
    if depth == M:
        print(' '.join(map(str, res)))
        return
    for i in range(idx, len(nums)):
        res.append(nums[i])
        solve(depth+1, i)
        res.pop()
solve(0,0)
p = sorted(list(set(p)))