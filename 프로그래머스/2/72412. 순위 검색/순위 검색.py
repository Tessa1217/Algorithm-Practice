from itertools import combinations

def solution(info, query):
    answer = []
    
    # 지원자 조건 4개로 만들 수 있는 조합 저장
    key_map = {}
    # java backend junior pizza 조건일 때
    for person in info:
        person_info = person.split(" ")
        for n in range(5):
            for comb in combinations([0, 1, 2, 3], n):
                temp_row = person_info.copy()
                for idx in comb:
                    temp_row[idx] = "-"                    
                new_key = tuple(temp_row[:-1])
                if new_key not in key_map.keys():
                    key_map[new_key] = []
                key_map[new_key].append(int(person_info[-1]))                                             
                
    for scores in key_map.values():
        scores.sort()
    
    for q in query:
        q_string = q.replace(" and", "").split(" ")
        q_key = tuple(q_string[:-1])
        score = int(q_string[-1])
        
        if q_key not in key_map.keys():
            answer.append(0)
            continue
            
        score_list = key_map[q_key]
          
        answer.append(find_score_over_cnt(score_list, score))                
        
    return answer

def find_score_over_cnt(score_list, score):    
    
    start, end = 0, len(score_list)

    while start < end:
        mid = (start + end) // 2
        if score_list[mid] < score:
            start = mid + 1
        else:
            end = mid       
            
    return len(score_list) - start            