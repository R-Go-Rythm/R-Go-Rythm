def combination(arr, n):
    result = []

    if n == 0:
        return [[]]

    for i in range(0, len(arr)):
        # 전체 배열 중 첫 인덱스 값과 나머지 값들의 배열로 슬라이싱
        elem = arr[i]
        rest_arr = arr[i + 1:]
        # 나머지 값들의 배열을 n-1만큼 재귀를 돌며 결과 배열들을 만들어낸다.
        for C in combination(rest_arr, n-1):
            result.append([elem]+C)

    return result

dwarf = [int(input()) for _ in range(9)]
r_dwarf = list(combination(dwarf, 7))

for i in r_dwarf:
    if sum(i) == 100:
        answer = list(i)
        break
answer.sort()
for i in answer:
    print(i)