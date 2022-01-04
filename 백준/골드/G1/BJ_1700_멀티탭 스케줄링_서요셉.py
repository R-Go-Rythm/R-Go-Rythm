import sys
input = sys.stdin.readline

N, K = map(int, input().split())
kind = list(map(int, input().split()))
plug = []
cnt = 0

for i in range(K):
    # 플러그 안에 사용용품이 이미 꽂혀있으면 그대로 진행
    if kind[i] in plug:
        continue
    # 플러그에 빈자리가 있으면 사용용품 꽂고 진행
    if len(plug) < N:
        plug.append(kind[i])
        continue

    # 플러그에 빈자리가 없고 다른 용품이라면 현재 꽂혀있는 사용용품의 다음 사용 순서를 알아낸다.
    idxs = []
    for j in range(N):
        try:
            idx = kind[i:].index(plug[j])
        # plug 최대 개수가 100이므로 현재 플러그에 꽂힌 용품의 다음 순서가 없다면 100보다 큰 수로 인덱스를 둔다.
        except:
            idx = 101
        idxs.append(idx)

    # 다음 사용순서에 없거나 가장 먼 것을 뽑고 cnt를 증가 시킨다.
    plug_out = idxs.index(max(idxs))
    del plug[plug_out]
    plug.append(kind[i])
    cnt += 1

print(cnt)

