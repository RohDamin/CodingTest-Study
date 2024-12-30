def solution(s):
    s_list = s.split(' ')
    ans = []
    for word in s_list:
        if word:
            word = word[0].upper() + word[1:].lower()
        ans.append(word)
    return ' '.join(ans)