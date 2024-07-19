import sys
document = sys.stdin.readline().strip()
target = sys.stdin.readline().strip()
split_word = document.split(target)
print(len(split_word)-1)