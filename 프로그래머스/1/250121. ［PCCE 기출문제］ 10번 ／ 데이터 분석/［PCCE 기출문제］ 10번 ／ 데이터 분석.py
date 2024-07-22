def solution(data, ext, val_ext, sort_by):
    
    answer = []
    
    # data에서 ext 값이 val_ext보다 작은 데이터만 뽑기
    ext_idx = 0
    if ext=="code":
        ext_idx = 0
    elif ext=="date":
        ext_idx = 1
    elif ext=="maximum":
        ext_idx = 2
    elif ext=="remain":
        ext_idx = 3
        
    for i in range(len(data)):
        if data[i][ext_idx] < val_ext:
            answer.append(data[i])
    
    
    # sort_by에 해당하는 값을 기준으로 오름차순으로 정렬
    if sort_by=="code":
        answer.sort(key=lambda a:a[0])
    elif sort_by=="date":
        answer.sort(key=lambda a:a[1])
    elif sort_by=="maximum":
        answer.sort(key=lambda a:a[2])
    elif sort_by=="remain":
        answer.sort(key=lambda a:a[3])
        
    # print(answer)
    
    return answer