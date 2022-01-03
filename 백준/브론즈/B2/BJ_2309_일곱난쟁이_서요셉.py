dwarf = []
for i in range(9):
    dwarf.append(int(input()))

sum_dwarf = sum(dwarf)
one = 0
two = 0
for i in range(8):
    for j in range(i+1, 9):
        if sum_dwarf - (dwarf[i] + dwarf[j]) == 100:
            one = dwarf[i]
            two = dwarf[j]
dwarf.remove(one)
dwarf.remove(two)
dwarf.sort()
for i in dwarf:
    print(i)