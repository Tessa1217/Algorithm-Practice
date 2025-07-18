# 말의 이동은 현재 위치에서 상, 하, 좌, 우 중 한 방향으로 게임판 위의 장애물이나 게임판 가장자리까지 부딪힐 때까지 미끄러져 움직인다
# 생각: 
#   목표 지점의 상하좌우 중 1개 이상이 가장자리에 맞닿아 있지 않거나 장애물이 없다면 말은 목표 지점을 지나치기만 하고 도달할 수는 없다
#   목표지점의 상하좌우가 모두 장애물로 막혀있거나 가장자리에 맞닿아 있을 경우 로봇은 영원히 목표 지점에 도달할 수 없다
#   => 위의 조건으로 목표 위치에 도달할 수 없는 경우의 수를 먼저 거른다
#   최단거리를 찾는 것이 목표이기 때문에 BFS 탐색을 진행한다 (이미 사전에 방문한 지점, 장애물이 있는 지점, 가장자리 너머의 지점을 거르고 탐색)

from collections import deque

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

def solution(board):
    
    n = len(board)
    m = len(board[0])      
    
    robot, goal = find_goal_and_robot(board)
    if not check_goal_reachable(board, goal):
        return -1
    
    # 방문 배열
    visited = {}    
    queue = deque([(robot[0], robot[1], 0)])
    
    while queue:
        
        cur_pos = queue.popleft()
        x, y, d = cur_pos
        
        for i in range(4):            
            mx, my = dx[i], dy[i]
            # print("방향: ", mx, my)
            nx, ny = x, y
            while is_robot_in_range(nx, ny, n, m):
                nx, ny = nx + mx, ny + my
                # print(nx, ny)
                if not is_robot_in_range(nx, ny, n, m) or board[nx][ny] == 'D':
                    nx, ny = nx - mx, ny - my
                    break
            # print("현재 로봇 위치: ", x, y, "새로운 로봇 위치:", nx, ny, "움직인 거리: ", d)                    
            if board[nx][ny] == 'G':
                return d + 1
            if not (nx, ny) in visited:
                visited.setdefault((nx, ny), True)
                queue.append((nx, ny, d + 1))
    
    return -1

# 최초의 목표지점과 로봇 지점 확인
def find_goal_and_robot(board):
    robot = (0, 0)
    goal = (0, 0)
    
    for i in range(len(board)):
        for j in range(len(board[0])):
            if board[i][j] == 'R':
                robot = (i, j)
            if board[i][j] == 'G':
                goal = (i, j)
    return (robot, goal)

# 목표 지점이 도달 가능한지 여부 판별
def check_goal_reachable(board, goal):    
    n = len(board)
    m = len(board[0])    
    x, y = goal
    around_goal = []
    
    for i in range(4):
        around_goal.append((x + dx[i], y + dy[i]))
    
    blocked_side_cnt = 0
    for gx, gy in around_goal:
        if not is_robot_in_range(gx, gy, n, m) or board[gx][gy] == 'D':
            blocked_side_cnt += 1
    
    if blocked_side_cnt == 0 or blocked_side_cnt == 4:
        return False
    
    return True

# 로봇이 board range 안에 있는지 확인
def is_robot_in_range(x, y, n, m):
    return x >= 0 and y >= 0 and x < n and y < m