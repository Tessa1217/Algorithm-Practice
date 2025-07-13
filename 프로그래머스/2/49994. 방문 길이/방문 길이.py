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
                
        map_route.add((nx, ny, rx, ry))
        map_route.add((rx, ry, nx, ny))
        
        rx, ry = nx, ny        
            
    return len(map_route) // 2