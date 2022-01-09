import sys
from heapq import heappush, heappop
input = sys.stdin.readline

N = int(input())
M = int(input())
INF = int(1e8)
graph = [[] for _ in range(N + 1)]
distances = [INF for _ in range(N + 1)]

for i in range(M):
    s, e, c = map(int, input().split())
    graph[s].append([e, c])
start, end = map(int, input().split())

def dijkstra(start):
    distances[start] = 0
    heap = []
    heappush(heap, [start, distances[start]])

    while heap:
        node, dist = heappop(heap)
        if distances[node] < dist:
            continue

        for n_node, n_dist in graph[node]:
            cost = n_dist + dist
            if distances[n_node] > cost:
                distances[n_node] = cost
                heappush(heap, [n_node, distances[n_node]])

dijkstra(start)
print(distances[end])