import sys
input = sys.stdin.readline

N, S = map(int, input().split())
a = list(map(int, input().split()))

sum_a = [0] * (N+1)
for i in range(1, N+1):
    sum_a[i] = sum_a[i-1] + a[i-1]

ans = 100001
start = 0
end = 1

while start != N:
    if sum_a[end] - sum_a[start] >= S:
        if end - start < ans:
            ans = end - start
        start += 1
    else:
        if end != N:
            end += 1
        else:
            start += 1

if ans != 100001:
    print(ans)
else:
    print(0)