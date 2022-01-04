from itertools import combinations
n, k = map(int, input().split())
if k < 5:
    print(0)
else:
    k -= 5
    n_chars = {'a', 'c', 'i', 'n', 't'}
    input_chars = []
    alpha = {k: v for v, k in enumerate((set(map(chr, range(ord('a'), ord('z')+1))) - n_chars))}
    cnt = 0

    for _ in range(n):
        tmp = 0
        for c in set(input()) - n_chars:
            tmp |= (1 << alpha[c])
        input_chars.append(tmp)

    power_by_2 = (2**i for i in range(21))
    for comb in combinations(power_by_2, k):
        test = sum(comb)

        ct = 0
        for cb in input_chars:
            if test & cb == cb:
                ct += 1

        cnt = max(cnt, ct)

    print(cnt)