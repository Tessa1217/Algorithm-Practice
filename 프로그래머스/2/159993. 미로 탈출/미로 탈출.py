from collections import deque

def solution(maps):
        
    n = len(maps)
    m = len(maps[0])
    
    # 최초 지점 세팅    
    start = find_init_spots(maps)    
    
    # queue
    queue = deque([(start[0], start[1], 0)])
    
    # lever queue - 레버 방문 후부터 exit까지 담을 큐
    lever_queue = deque([])
    
    dx = [1, -1, 0, 0]
    dy = [0, 0, 1, -1]
    
    visited = {}
    visited[(start[0], start[1])] = True
    
    # 레버를 먼저 누르고 탈출구를 가야 열리기 때문에 레버로 가는 최단거리 먼저 구하기
    while queue:
        cur_pos = queue.popleft()    
        x, y, d = cur_pos
        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]
            if is_in_range(nx, ny, n, m) and (nx, ny) not in visited:                
                if maps[nx][ny] == 'L':
                    lever_queue.append((nx, ny, d + 1))
                    continue
                if maps[nx][ny] != 'X':
                    visited[(nx, ny)] = True
                    queue.append((nx, ny, d + 1))
                
    # 만약에 레버를 도달할 수 없다면 return -1                
    if len(lever_queue) == 0:
        return -1
    
    visited = {}
    
    while lever_queue:
        cur_pos = lever_queue.popleft()
        x, y, d = cur_pos
        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]
            if is_in_range(nx, ny, n, m) and (nx, ny) not in visited:                
                if maps[nx][ny] == 'E':
                    return d + 1
                if maps[nx][ny] != 'X':
                    visited[(nx, ny)] = True
                    lever_queue.append((nx, ny, d + 1))
                
    return -1

def is_in_range(x, y, n, m):
    return x >= 0 and y >= 0 and x < n and y < m

def find_init_spots(maps):   
    start = list()
    for i in range(len(maps)):
        for j in range(len(maps[0])):
            if maps[i][j] == 'S':
                start.append(i)
                start.append(j)
    return start