from itertools import combinations

def solution(n, q, ans):
        
    num_candidate = list()
    for i in range(1, n + 1):
        num_candidate.append(i)                
    
    if 0 in ans:        
        for i in range(len(ans)):
            if ans[i] == 0:                
                for not_possible_num in q[i]:                    
                    if not_possible_num in num_candidate:
                        num_candidate.remove(not_possible_num)                            
                        
    # 가능한 조합                        
    possible_list = []         
    # 최대 횟수
    m = len(ans)
        
    # 가능한 조합 모두 구해서 검사
    for comb in combinations(num_candidate, 5):        
        for i in range(m):            
            cond_cnt = ans[i]    
            cur_cnt = 0            
            for qc in q[i]:
                if qc in comb:                    
                    cur_cnt += 1
                # 현재 카운트가 조건 카운트 보다 크다면
                if cur_cnt > cond_cnt:
                    break         
            # 조건을 다 돌았을 때 현재 카운트와 조건 카운트의 합이 안 맞다면
            if cond_cnt != cur_cnt:
                break            
            if i == len(ans) - 1:
                possible_list.append(comb)                                          
             
    return len(possible_list)