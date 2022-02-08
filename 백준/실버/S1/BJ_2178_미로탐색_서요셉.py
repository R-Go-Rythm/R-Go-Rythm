from collections import deque

def bfs(i, j):
    q = deque()
    q.append((i, j))
    visited[i][j] = 1

    while(q):
        x, y = q.popleft()

        for d in range(4):
            nx = x + dx[d]
            ny = y + dy[d]

            if 0 <= nx < n and 0 <= ny < m:
                if graph[nx][ny] == 1 and visited[nx][ny] == 0:
                    q.append((nx, ny))
                    visited[nx][ny] = 1
                    graph[nx][ny] = graph[x][y] + 1

    return graph[n-1][m-1]


dx = [0,0,-1,1]
dy = [-1,1,0,0]
n, m = map(int, input().split())
graph = [list(map(int, input())) for _ in range(n)]
visited = [[0] * m for _ in range(n)]

print(bfs(0, 0))