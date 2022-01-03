def sol1():
    n = int(input())
    numbers = map(int, input().split())

    p_num = 0
    for num in numbers:
        error = 0
        if num > 1:
            for i in range(2, num):
                if num % i == 0:
                    error += 1
            if error == 0:
                p_num += 1

    print(p_num)

def sol2():
    n = int(input())
    cnt = 0
    numbers = list(map(int, input().split()))
    numbers.sort()

    def prime_list(n):
        sieve = [True] * (n+1)
        m = int(n ** 0.5)

        for i in range(2, m+1):
            if sieve[i]:
                for j in range(i+i, n+1, i):
                    sieve[j] = False

        return [i for i in range(2, n+1) if sieve[i]]

    for num in prime_list(numbers[-1]):
        if num in numbers:
            cnt += 1

    print(cnt)

# sol1()
sol2()