def solution(s, n):
    answer = []
    for i in range(len(s)):
        if s[i] == ' ':
            answer.append(' ')
            continue
        
        if s[i].isupper():
            ascii_num = ord(s[i])+n
            if ascii_num > 90:
                ascii_num -= 26
            answer.append(chr(ascii_num))
        else:
            ascii_num = ord(s[i])+n
            if ascii_num > 122:
                ascii_num -= 26
            answer.append(chr(ascii_num))
            
    return ''.join(answer)