def solution(bandage, health, attacks):
    t = bandage[0]
    x = bandage[1]
    y = bandage[2]
    
    hp = health
    
    time = 0
    attacksIdx = 0
    bandageTime = 0
    while(time <= attacks[-1][0]):
        if time == attacks[attacksIdx][0]: # 공격받는 경우
            hp -= attacks[attacksIdx][1]
            bandageTime = 0
            attacksIdx+=1
            if hp <= 0:
                hp = -1
                break
        else: # 공격받지 않는 경우
            bandageTime += 1
            hp = min(health, hp+x)
            if (bandageTime == t):
                bandageTime = 0
                hp = min(health, hp+y)
        time+=1       
    return hp

    
