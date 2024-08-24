import sys

croatia = ['c=', 'c-', 'dz=', 'd-', 'lj', 'nj', 's=', 'z=']
inputStr = sys.stdin.readline().strip()

for sub in croatia:
    inputStr = inputStr.replace(sub, '*')

print(len(inputStr))