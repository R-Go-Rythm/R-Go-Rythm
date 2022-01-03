def GCD(a, b):
    # 유클리드 호제
    # ex) 1112 % 695 = 417, 695 % 417 = 278, 417 % 278 = 139, 278 % 139 = 0
    # 139가 GCD임
    while b:
        a, b = b, a % b
    return a

def LCM(a, b):
    return a * b // GCD(a, b)

a, b = map(int, input().split())
print(GCD(a, b))
print(LCM(a, b))