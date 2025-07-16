from itertools import combinations
N,M = map(int,input().split())
input_map = list(list(map(int, input().split())) for _ in range(N))

def get_min_city_chicken_distance(n, m, city_map):
    # 각 집과 치킨집의 위치를 구한다
    houses = []
    chickens = []

    for r in range(n):
        for c in range(n):
            if city_map[r][c] == 1:
                houses.append((r, c))
            elif city_map[r][c] == 2:
                chickens.append((r, c))

    min_total_distance = float('inf')
    
    # 집의 조합을 활용해서 최소 거리를 구한다
    for selected_chickens in combinations(chickens, m):
        total_distance = 0
        # 각 집에 대해서 선정된 조합의 치킨 지점에 대한 치킨 거리 구하기
        for hr, hc in houses:
            min_distance = float('inf')
            for cr, cc in selected_chickens:
                distance = abs(hr - cr) + abs(hc - cc)
                min_distance = min(min_distance, distance)
            # 치킨 거리를 조합에 대한 치킨 거리에 더하기
            total_distance += min_distance
        min_total_distance = min(min_total_distance, total_distance)

    return min_total_distance

print(get_min_city_chicken_distance(N, M, input_map))
