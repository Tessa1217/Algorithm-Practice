import sys

input = sys.stdin.readline

N, K = map(int, input().split())

# 체스판
chess_map = [list(map(int, input().split())) for _ in range(N)]
# 체스판 말 위치 저장
horse_location_and_directions = []

while len(horse_location_and_directions) < K:
    line = input()
    if not line.strip():
        continue  # 빈 줄 건너뜀
    try:
        r, c, d = map(int, line.strip().split())
        horse_location_and_directions.append([r - 1, c - 1, d - 1])
    except ValueError:        
        continue

# directions
# 동 서 북 남
# →, ←, ↑, ↓
dr = [0, 0, -1, 1]
dc = [1, -1, 0, 0]


# 체스말이 체스판의 끝을 넘어가는지 여부
def is_horse_at_the_border(horse_r, horse_c, n):
    if horse_r < 0 or horse_r >= n or horse_c < 0 or horse_c >= n:
        return True
    return False


def make_horse_turn_around(d):
    if d % 2 == 0:
        return d + 1
    else:
        return d - 1


def get_game_over_turn_count(horse_count, game_map, horse_loc):

    n = len(game_map)

    # 맵의 위치별로 가는 중인 말의 위치 저장 dict
    map_horse = {}
    for i in range(len(game_map)):
        map_horse[i] = {}
        for j in range(len(game_map)):
            map_horse[i][j] = []

    # 최초 말 세팅
    for i in range(horse_count):
        r, c, d = horse_loc[i]
        map_horse[r][c].append(i)

    # turn 카운트
    turn_cnt = 1

    while turn_cnt < 1000:
        for i in range(horse_count):
            
            r, c, d = horse_loc[i]
            horse_arr = [i]
            
            if i in map_horse[r][c]:
                idx = map_horse[r][c].index(i)
                # 현재 말보다 위에 있는 말까지 포함해서 구하기
                horse_arr = map_horse[r][c][idx:]
                # 옮기는 말 제외하고 남겨놓기
                map_horse[r][c] = map_horse[r][c][:idx]

            # 말이 옮겨가는 위치
            nr, nc = r + dr[d], c + dc[d]

            # 체스판 벗어나는 경우의 상황 또는 파란색인 상황
            if is_horse_at_the_border(nr, nc, n) or game_map[nr][nc] == 2:
                d = make_horse_turn_around(d)
                # 말의 방향 변경
                horse_loc[i][2] = d
                nr, nc = r + dr[d], c + dc[d]
                # 만약 옮겼는데도 코너 못 벗어나거나 파란색인 경우
                if is_horse_at_the_border(nr, nc, n) or game_map[nr][nc] == 2:
                    for horse in horse_arr:
                        map_horse[r][c].append(horse)
                    continue

            if game_map[nr][nc] == 1:  # 빨간색일 때
                horse_arr.reverse()

            for horse in horse_arr:
                horse_loc[horse][0], horse_loc[horse][1] = nr, nc
                map_horse[nr][nc].append(horse)

            # 말 4개 이상 쌓였을 때
            if len(map_horse[nr][nc]) >= 4:
                return turn_cnt
            
        turn_cnt += 1
    # 1000번째부터는 더 이상 게임 진행 하지 않음
    return -1


print(get_game_over_turn_count(K, chess_map, horse_location_and_directions))