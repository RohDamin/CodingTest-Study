dx = [0,0,-1,1]
dy = [1,-1,0,0]

def solution(board, h, w):
    cnt = 0
    for i in range(4):
        nx = w+dx[i]
        ny = h+dy[i]
        if (isRange(ny, nx, len(board[0]))):
            if board[h][w] == board[ny][nx]:
                cnt+=1
    return cnt

def isRange(y, x, n):
    return x<n and x>=0 and y<n and y>=0