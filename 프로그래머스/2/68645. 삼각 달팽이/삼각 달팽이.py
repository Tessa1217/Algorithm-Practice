def solution(n):
    
    triangle = [[0] * i for i in range(1, n + 1)]
    
    x, y = -1, 0
    num = 1
    
    # 좌 -> 하 -> 우 순으로 채우기
    # 직각 삼각형으로 생각하고 채우기
    for i in range(n):
        for _ in range(i, n):
            # 좌측 채우기
            if i % 3 == 0:
                x += 1
            # 바닥 채우기
            if i % 3 == 1:
                y += 1
            # 우측 채우기
            if i % 3 == 2:
                x -= 1
                y -= 1
            triangle[x][y] = num
            num += 1             
            
    return [triangle[i][x] for i in range(n) for x in range(len(triangle[i]))]