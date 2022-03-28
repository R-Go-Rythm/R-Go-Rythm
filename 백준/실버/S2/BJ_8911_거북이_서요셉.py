T = int(input())
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

for i in range(T):
    cx = 0
    cy = 0
    cd = 0
    move = list(input())
    trace = [(cx, cy)]
    for j in move:
        if j == "F":
            cx = cx + dx[cd]
            cy = cy + dy[cd]
        elif j == "B":
            cx = cx - dx[cd]
            cy = cy - dy[cd]
        elif j == "L":
            if cd == 3:
                cd = 0
            else:
                cd += 1
        elif j == "R":
            if cd == 0:
                cd = 3
            else:
                cd -= 1

        trace.append((cx, cy))

    width = max(trace, key=lambda x:x[0])[0] - min(trace, key=lambda x:x[0])[0]
    height = max(trace, key=lambda x:x[1])[1] - min(trace, key=lambda x:x[1])[1]
    print(width * height)