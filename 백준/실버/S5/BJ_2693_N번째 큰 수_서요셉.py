# 배열 A가 주어졌을 때, N번째 큰 값 출력.
# 배열 A 크기는 항상 10. 자연수만 가짐. N은 항상 3

def sol1():
    for _ in range(int(input())):
        A = list(map(int, input().split()))
        A.sort()
        print(A[-3])

import sys
input = sys.stdin.readline
def sol2():
    for i in range(int(input())):
        l = sorted(map(int, input().split()))
        print(l[-3])

sol2()