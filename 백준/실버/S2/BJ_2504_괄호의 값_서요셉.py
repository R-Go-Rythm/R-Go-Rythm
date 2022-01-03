import sys
input = sys.stdin.readline

bracket = list(input())
stack = []
ans = 0
tmp = 1

for i in range(len(bracket)):
    if bracket[i] == "(":
        stack.append(bracket[i])
        tmp *= 2
    elif bracket[i] == "[":
        stack.append(bracket[i])
        tmp *= 3
    elif bracket[i] == ")":
        if not stack or stack[-1] == "[":
            ans = 0
            break
        if bracket[i-1] == "(":
            ans += tmp
        stack.pop()
        tmp //= 2

    elif bracket[i] == "]":
        if not stack or stack[-1] == "(":
            ans = 0
            break
        if bracket[i-1] == "[":
            ans += tmp
        stack.pop()
        tmp //= 3

if stack:
    print(0)
else:
    print(ans)