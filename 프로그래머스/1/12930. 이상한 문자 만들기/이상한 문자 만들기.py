def solution(s):
    s_split = s.split(' ')
    ans = []
    
    for word in s_split:
        new_word = ''
        for j in range(len(word)):
            if j % 2 == 0:
                new_word += word[j].upper()
            else:
                new_word += word[j].lower()
        ans.append(new_word)
    return ' '.join(ans)