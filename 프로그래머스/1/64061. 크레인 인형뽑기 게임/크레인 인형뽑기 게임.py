def solution(board, moves):
    
    # 0 0 0 0 0
    # 0 0 1 0 3
    # 0 2 5 0 1
    # 4 2 4 4 2
    # 3 5 1 3 1

    # 크레인은 moves의 순서대로 인형을 바구니에 옮긴다
    # * 이때 인형이 없다면 아무 일도 일어나지 않는다 (바구니에 아무것도 옮겨지지 않음)
    # 바구니는 모든 인형이 들어갈 수 있는 크기이다
    # 만약 같은 모양의 인형 두 개가 바구니에 연속해서 쌓이게 되면 두 인형은 터뜨려지면서 바구니에서 사라지게 된다 
    
    # 바구니에 들어가는 순서
    # 4 (1) -> 3 (5) -> 1 (3) -> 1 (5) => 이때 1번 인형 두 개가 사라짐 [1, 5, 3, 5]
    # 4 (1) -> 3 (5) -> 3 (1) => 이때 3번 인형 두 개가 사라짐 [1, 5, 3, 5, 1]
    # 4 (1) -> 2 (2) -> (1번은 비어있으므로 아무것도 안 쌓임) 4 (4) => 최종적으로 3개가 남았으며 사라진 인형은 4개, 총 움직임은 7번
    
    basket = []
    n = len(board)
    moved_doll_cnt = 0
    
    for move in moves:
        
        doll = 0
        
        for i in range(n):            
            if board[i][move - 1] > 0:
                doll = board[i][move - 1]
                board[i][move - 1] = 0
                break
        
        if doll == 0:
            continue
            
        moved_doll_cnt += 1
        
        if len(basket) > 0 and doll == basket[-1]:
            basket.pop()
        else:
            basket.append(doll)
    
    return moved_doll_cnt - len(basket)