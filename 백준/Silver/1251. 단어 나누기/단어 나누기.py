word = input()
words = []

for i in range(1, len(word)):
    for j in range(i + 1, len(word)):
        w1 = word[:i][::-1]
        w2 = word[i:j][::-1]
        w3 = word[j:][::-1]
        words.append(w1+w2+w3)

print(sorted(words)[0])