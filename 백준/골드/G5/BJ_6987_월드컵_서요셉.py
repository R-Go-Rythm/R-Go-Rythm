from itertools import combinations
import sys
input = sys.stdin.readline

def dfs(cnt):
    global ans, w, l, d
    if cnt == 15:
        if w.count(0) == 6 and l.count(0)

game = list(combinations(range(6), 2))
result = []
for i in range(4):
    a = list(map(int, input().split()))
    w, l, d = [], [], []
    for j in range(18):
        if j % 3 == 0: w.append(a[j])
        elif j % 3 == 1: l.append(a[j])
        elif j % 3 == 2: d.append(a[j])

    ans = 0
    dfs(0)
    result.append(ans)

print(*result)