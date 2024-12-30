def solution(participant, completion):
    map = {}
    for p in participant:
        if p in map:
            map[p] += 1
        else:
            map[p] = 1
    for c in completion:
        map[c] -= 1
        if map[c] == 0:
            del map[c]
    
    return next(iter(map))