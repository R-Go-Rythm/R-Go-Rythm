from collections import deque
import sys
input = sys.stdin.readline


def destroy(idx, left):
    x, y = r - idx, 0
    if left == 1:
        for i in range(c):
            if cave[x][i] == 'x':
                cave[x][i] = '.'
                y = i
                break
    else:
        for i in range(c-1, -1, -1):
            if cave[x][i] == 'x':
                cave[x][i] = '.'
                y = i
                break

    for d in range(4):
        nx = x + dx[d]
        ny = y + dy[d]

        if 0 <= nx < r and 0 <= ny < c:
            if cave[nx][ny] == 'x':
                cluster.append([nx, ny])


def bfs(i, j):
    q = deque()
    q.append([i, j])
    check = [[0] * c for _ in range(r)]
    check[i][j] = 1
    fall_list = []

    while q:
        x, y = q.popleft()

        if x == r - 1:
            return
        if cave[x+1][y] == ".":
            fall_list.append([x, y])

        for d in range(4):
            nx = x + dx[d]
            ny = y + dy[d]

            if 0 <= nx < r and 0 <= ny < c:
                if cave[nx][ny] == 'x' and not check[nx][ny]:
                    q.append([nx, ny])
                    check[nx][ny] = 1

    fall(check, fall_list)


def fall(check, fall_list):
    k, flag = 1, 0

    while True:
        for i, j in fall_list:
            if i + k == r - 1:
                flag = 1
                break
            if cave[i+k+1][j] == 'x' and not check[i+k+1][j]:
                flag = 1
                break
        if flag:
            break
        k += 1

    for i in range(r - 2, -1, -1):
        for j in range(c):
            if cave[i][j] == 'x' and check[i][j]:
                cave[i][j] = '.'
                cave[i+k][j] = 'x'


r, c = map(int, input().split())
cave = [list(input().strip()) for _ in range(r)]
n = int(input())
h = list(map(int, input().split()))
cluster = deque()

dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]

left = 1
while n:
    idx = h.pop(0)
    destroy(idx, left)

    while cluster:
        x, y = cluster.popleft()
        bfs(x, y)

    left *= -1
    n -= 1

for i in range(r):
    for j in range(c):
        print(cave[i][j], end='')
    print()
