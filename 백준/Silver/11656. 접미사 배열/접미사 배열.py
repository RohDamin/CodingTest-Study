#문자열
S = input()
suffix = []

for i in range(len(S)):
    suffix.append(S[i:])
suffix.sort()
for i in range(len(suffix)):
    print(suffix[i])