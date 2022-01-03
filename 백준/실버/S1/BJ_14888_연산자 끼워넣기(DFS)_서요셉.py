import sys
input = sys.stdin.readline

N = int(input())
numbers = list(map(int, input().split()))
op = list(map(int, input().split()))

maximum = -1e9
minimum = 1e9

def dfs(depth, total, plus, minus, mul, div):
    global maximum, minimum
    if depth == N:
        maximum = max(total, maximum)
        minimum = min(total, minimum)
        return

    if plus:
        dfs(depth + 1, total + numbers[depth], plus - 1, minus, mul, div)
    if minus:
        dfs(depth + 1, total - numbers[depth], plus, minus - 1, mul, div)
    if mul:
        dfs(depth + 1, total * numbers[depth], plus, minus, mul - 1, div)
    if div:
        dfs(depth + 1, int(total / numbers[depth]), plus, minus, mul, div - 1)

dfs(1, numbers[0], op[0], op[1], op[2], op[3])
print(maximum)
print(minimum)