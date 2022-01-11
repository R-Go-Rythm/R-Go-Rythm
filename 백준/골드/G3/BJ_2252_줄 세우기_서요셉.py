import sys
from collections import deque
input = sys.stdin.readline

N, M = map(int, input().split())
graph = [[] for _ in range(N + 1)]
isDegree = [0] * (N + 1)
queue = deque()

# 그래프 정보를 입력받고 간선을 연결할 때마다 그 노드에 대한 진입 차수 1씩 더한다
for _ in range(M):
    a, b = map(int, input().split())
    graph[a].append(b)
    isDegree[b] += 1

# 진입 차수가 0인 노드들을 큐에 넣는다
for i in range(1, N+1):
    if isDegree[i] == 0:
        queue.append(i)

# 노드를 뽑고 그 노드의 진입차수를 1씩 줄이며(간선 삭제) 진입차수가 0이면 큐에 넣고 이 과정을 반복한다.
ans = []
while queue:
    node = queue.popleft()
    ans.append(node)

    for i in graph[node]:
        isDegree[i] -= 1
        if isDegree[i] == 0:
            queue.append(i)

for i in ans:
    print(i, end=' ')
