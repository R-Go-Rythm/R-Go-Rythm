N, K = map(int, input().split())
d_list = []
for i in range(1, N+1):
    if N % i == 0:
        d_list.append(i)

if len(d_list) < K:
    print(0)
else:
    print(d_list[K-1])

# 약수의 개수를 먼저 찾자.
    # 약수인 수의 배열을 하나 만들어 약수들을 저장하고 그 길이가 K보다 작으면 0 출력
    # 아니면 K번째 수 출력
