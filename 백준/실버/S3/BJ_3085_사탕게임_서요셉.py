import sys
input = sys.stdin.readline

N = int(input())
board = [list(input()) for _ in range(N)]
ans = 0

def check(b, sr, er, sc, ec):
    length = len(board)
    res = 1
    for i in range(sr, er+1):
        cnt = 1
        for j in range(1, length):
            if b[i][j-1] == b[i][j]:
                cnt += 1
            else:
                cnt = 1
            if cnt > res:
                res = cnt
    for i in range(sc, ec+1):
        cnt = 1
        for j in range(1, length):
            if b[j-1][i] == b[j][i]:
                cnt += 1
            else:
                cnt = 1
            if cnt > res:
                res = cnt

    return res

for i in range(N):
    for j in range(N):
        if j < N - 1:
            board[i][j], board[i][j+1] = board[i][j+1], board[i][j]
            cont = check(board, i, i, j, j+1)
            if cont > ans:
                ans = cont
            board[i][j], board[i][j+1] = board[i][j+1], board[i][j]
        if i < N - 1:
            board[i][j], board[i+1][j] = board[i+1][j], board[i][j]
            cont = check(board, i, i+1, j, j)
            if cont > ans:
                ans = cont
            board[i][j], board[i+1][j] = board[i+1][j], board[i][j]

print(ans)
