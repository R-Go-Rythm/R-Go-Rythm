from collections import deque
import sys
input = sys.stdin.readline

def bfs(i, j, c):
    cnt = 1
    q = deque()
    q.append((i, j))
    visited[i][j] = 1

    while(q):
        x, y = q.popleft()

        for d in range(4):
            nx = x + dx[d]
            ny = y + dy[d]

            if 0 <= nx < m and 0 <= ny < n:
                if graph[nx][ny] == c and visited[nx][ny] == 0:
                    q.append((nx, ny))
                    visited[nx][ny] = 1
                    cnt += 1

    return cnt

dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]

n, m = map(int, input().split())
graph = [list(input()) for _ in range(m)]
visited = [[0] * n for _ in range(m)]

w, b = 0, 0
for i in range(m):
    for j in range(n):
        if graph[i][j] == 'W' and visited[i][j] == 0:
            w += bfs(i, j, 'W') ** 2
        elif graph[i][j] == 'B' and visited[i][j] == 0:
            b += bfs(i, j, 'B') ** 2

print(w, b)
