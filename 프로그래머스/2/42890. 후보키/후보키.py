from itertools import combinations
def solution(relation):
    answer = 0    
    key_length = len(relation[0])
    arr = [i for i in range(key_length)]
    key_comb = list(c for i in range(1, key_length + 1) for c in combinations(arr, i))
    
    candidates = []
    visited = []
    for key in key_comb:
        data_key_set = generate_based_on_candidates(key, relation)           
        if len(data_key_set) == len(relation) and not check_if_key_exists(key, visited):            
            candidates.append(key)
            visited.append("".join(map(str, key)))            
                                
    return len(candidates)

def generate_based_on_candidates(key, relation):
    key_set = set()
    for row in relation:
        str = ''
        for k in list(key):
            str += row[k] + "&" # spliter
        key_set.add(str)
    return key_set

# 최소성 만족을 위해 sub set인지 확인
def check_if_key_exists(key, visited):
    key_set = set(key)
    for v in visited:        
        v_set = set(map(int, v))        
        if v_set.issubset(key_set):            
            return True
    return False