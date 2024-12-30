import math

def solution(progresses, speeds):
    answer = []
    # 7 1 / 9 -> 2 1
    # 5 / 10 1 1 / 20 1
    
    days = []

    for i in range(len(progresses)):
        days.append(math.ceil((100-progresses[i]) / speeds[i]))
        
    count = 1
    max_day = days[0]
    for i in range(1, len(days)):
        if days[i] > max_day:
            answer.append(count)
            max_day = days[i]
            count = 1
        else:
            count += 1
    answer.append(count)
    return answer