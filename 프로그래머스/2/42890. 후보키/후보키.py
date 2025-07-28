from itertools import combinations
def solution(relation):
    num_cols = len(relation[0])
    all_col_indices = range(num_cols)
    
    all_combinations = [comb for i in range(1, num_cols + 1) for comb in combinations(all_col_indices, i)]
    
    candidate_keys = []
    
    for comb in all_combinations:
        if is_unique(comb, relation) and is_minimal(comb, candidate_keys):
            candidate_keys.append(set(comb))
            
    return len(candidate_keys)

def is_unique(comb, relation):
    projected = {tuple(row[i] for i in comb) for row in relation}
    return len(projected) == len(relation)

def is_minimal(comb, candidate_keys):
    comb_set = set(comb)
    for key in candidate_keys:
        if key.issubset(comb_set):
            return False
    return True