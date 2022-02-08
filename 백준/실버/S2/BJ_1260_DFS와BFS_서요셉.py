from collections import deque
import sys
input = sys.stdin.readline

def dfs(v):
    print(v, end=' ')
    d_visit[v] = 1

    for i in range(1, n+1):
        if d_visit[i] == 0 and graph[v][i] == 1:
            dfs(i)

def bfs(v):
    q = deque()
    q.append(v)
    b_visit[v] = 1

    while(q):
        nv = q.popleft()
        print(nv, end=' ')

        for i in range(1, n+1):
            if b_visit[i] == 0 and graph[nv][i] == 1:
                q.append(i)
                b_visit[i] = 1

n, m, v = map(int, input().split())
graph = [[0] * (n+1) for _ in range(n+1)]
d_visit = [0] * (n+1)
b_visit = [0] * (n+1)

for i in range(m):
    x, y = map(int, input().split())
    graph[x][y] = graph[y][x] = 1

dfs(v)
print()
bfs(v)