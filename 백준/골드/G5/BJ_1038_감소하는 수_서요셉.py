from itertools import combinations
import sys
input = sys.stdin.readline

N = int(input())
nums = []
for i in range(1, 11):
    for comb in combinations(range(0, 10), i):
        comb = list(comb)
        comb.sort(reverse=True)
        nums.append(int("".join(map(str, comb))))

nums.sort()

try:
    print(nums[N])
except:
    print(-1)