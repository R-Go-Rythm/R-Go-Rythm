from itertools import combinations

dwarf = [int(input()) for _ in range(9)]
r_dwarf = list(combinations(dwarf, 7))

for i in r_dwarf:
    if sum(i) == 100:
        answer = list(i)
        break
answer.sort()
for i in answer:
    print(i)