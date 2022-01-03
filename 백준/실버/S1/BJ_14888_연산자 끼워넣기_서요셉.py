import sys
from itertools import permutations as perm
input = sys.stdin.readline

N = int(input())
numbers = list(map(int, input().split()))
op_nums = list(map(int, input().split()))   # 0 0 1 0
op_list = ['+', '-', '*', '/']
op = []

for i in range(len(op_nums)):
    for j in range(op_nums[i]):
        op.append(op_list[i])

maximum = -1e9
minimum = 1e9

def solve():
    global maximum, minimum
    for case in perm(op, N-1):
        ans = numbers[0]
        for r in range(1, N):
            if case[r-1] == '+':
                ans += numbers[r]
            elif case[r-1] == '-':
                ans -= numbers[r]
            elif case[r-1] == '*':
                ans *= numbers[r]
            elif case[r-1] == '/':
                ans = int(ans / numbers[r])

        if ans > maximum:
            maximum = ans
        if ans < minimum:
            minimum = ans

solve()
print(maximum)
print(minimum)