import sys

vowel = ['a', 'e', 'i', 'o', 'u']
while True:
    inputString = sys.stdin.readline().rstrip().lower()

    if inputString == "#":
        break
    for i in range (len(vowel)):
        if vowel[i] in inputString:
            inputString = inputString.replace(vowel[i], '*')
    print(inputString.count('*'))