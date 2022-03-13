from collections import deque

n, m = map(int, input().split())
arr = []
safe_dist = 0

dx = [-1, -1, 0, 1, 1, 1, 0, -1]
dy = [0, 1, 1, 1, 0, -1, -1, -1]

q = deque()
for i in range(n):
    temp = list(map(int, input().split()))
    for j in range(m):
        if temp[j] == 1:
            q.append((i, j))
    arr.append(temp)

def bfs():
    while q:
        x, y = q.popleft()

        for d in range(8):
            nx = x + dx[d]
            ny = y + dy[d]

            if 0 <= nx < n and 0 <= ny < m:
                if arr[nx][ny] == 0:
                    q.append((nx, ny))
                    arr[nx][ny] = arr[x][y] + 1

    return

bfs()
for i in range(n):
    for j in range(m):
        safe_dist = max(safe_dist, arr[i][j])

print(safe_dist - 1)
