t = 0
t_list = []

for i in range(10):
    nae, tan = map(int, input().split())
    t = t - nae + tan
    t_list.append(t)

print(max(t_list))
