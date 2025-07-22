def solution(cards):
    answer = 0
    # 상자 번호별로 골랐을 때 그룹 1과 그룹 2를 구한다
    for i in range(len(cards)):
        first_box_group = []
        visited = [False for _ in range(len(cards) + 1)]
        box = cards[i] - 1       
        while not visited[cards[box]]:
            visited[cards[box]] = True
            first_box_group.append(cards[box])
            box = cards[box] - 1
        
        second_box_group = []
        for card in cards:
            if card not in first_box_group:
                second_box_group.append(card)
                
        for j in range(len(second_box_group)):
            second_box = []
            visited = [False for _ in range(len(cards) + 1)]
            box = second_box_group[j] - 1
            while not visited[cards[box]]:
                visited[cards[box]] = True
                second_box.append(cards[box])
                box = cards[box] - 1
            answer = max(len(first_box_group) * len(second_box), answer)
            
    return answer



# 1번 상자 열기 => 8
# 8번 상자 열기 => 4
# 4번 상자 열기 => 7
# 7번 상자 열기 => 1

# 2번 상자 열기 => 6
# 6번 상자 열기 => 5
# 5번 상자 열기 => 2