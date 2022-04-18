from collections import deque

graph = []
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
ans = 0

def bfs(a, b, c):
    q = deque()
    q.append([a, b])
    pang = deque()
    pang.append([a, b])

    visited = [[False] * 6 for _ in range(12)]
    visited[a][b] = True
    cnt = 1
    flag = 0

    while q:
        x, y = q.popleft()

        for d in range(4):
            nx = x + dx[d]
            ny = y + dy[d]

            if 0 <= nx < 12 and 0 <= ny < 6:
                if graph[nx][ny] == c and not visited[nx][ny]:
                    q.append([nx, ny])
                    pang.append([nx, ny])
                    visited[nx][ny] = True
                    cnt += 1

    if cnt >= 4:
        flag = 1

        for x, y in pang:
            graph[x][y] = "."

    return flag


def gravity():
    for y in range(6):
        q = deque()
        for x in range(11, -1, -1):
            if graph[x][y] != ".":
                q.append(graph[x][y])
        for x in range(11, -1, -1):
            if q:
                graph[x][y] = q.popleft()
            else:
                graph[x][y] = "."


for i in range(12):
    graph.append(list(input()))

while True:
    chain = 0

    for i in range(12):
        for j in range(6):
            if graph[i][j] != ".":
                chain += bfs(i, j, graph[i][j])

    if chain == 0:
        print(ans)
        break
    else:
        ans += 1
    gravity()

