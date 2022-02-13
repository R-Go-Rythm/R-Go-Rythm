import sys
from collections import deque

n, m, k = map(int, input().split())
graph = [[0] * m for _ in range(n)]
visited = [[0] * m for _ in range(n)]

dr = [-1, 1, 0, 0]
dc = [0, 0, -1, 1]

ans = 0
v = 0

def bfs(i, j):
    global v
    q = deque()
    q.append((i, j))
    visited[i][j] = 1
    v += 1

    while q:
        r, c = q.popleft()

        for d in range(4):
            nr = r + dr[d]
            nc = c + dc[d]

            if 0 <= nr < n and 0 <= nc < m:
                if graph[nr][nc] == 1 and visited[nr][nc] == 0:
                    q.append((nr, nc))
                    visited[nr][nc] = 1
                    v += 1

for _ in range(k):
    x, y = map(int, input().split())
    graph[x-1][y-1] = 1

for i in range(n):
    for j in range(m):
        if graph[i][j] == 1:
            bfs(i, j)
            ans = max(ans, v)
            v = 0

print(ans)










