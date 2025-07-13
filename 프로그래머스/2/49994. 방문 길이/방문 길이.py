def solution(dirs):
    # mapping dictionary
    map = {"U" : [1, 0], "D" : [-1, 0], "R": [0, 1], "L" : [0, -1]}
            
    map_route = set([])
    
    rx = 0
    ry = 0
    
    for d in dirs:
        move_route = map[d]
        nx, ny = rx + move_route[0], ry + move_route[1]        
        
        if nx < -5 or nx > 5 or ny < -5 or ny > 5:
            continue
                
        cur_x, cur_y = rx, ry            
        
        rx, ry = nx, ny
                
        if nx > cur_x:
            cur_x, nx = nx, cur_x
        if ny > cur_y:
            cur_y, ny = ny, cur_y
                
        map_route.add(str(cur_x) + str(cur_y) + str(nx) + str(ny))
                
            
    return len(map_route)