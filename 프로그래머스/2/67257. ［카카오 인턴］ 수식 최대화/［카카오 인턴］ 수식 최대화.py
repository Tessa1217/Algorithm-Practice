from itertools import permutations

def solution(expression):

    exp_list = []
    full_list = []
    
    idx = 0
    number = ''
    while idx < len(expression):
        if expression[idx].isnumeric():
            number += expression[idx]
            idx += 1
            continue
        exp_list.append(expression[idx])
        full_list.append(int(number))
        full_list.append(expression[idx])        
        number = ''
        idx += 1   
    full_list.append(int(number))
        
    exp_list = list(set(exp_list))    
    
    max_prize = 0
    
    for exp_tuple in permutations(exp_list, len(exp_list)):
        prize_per_tuple = calculate_prize(full_list[:], exp_tuple)
        max_prize = max(max_prize, prize_per_tuple)                
            
    return max_prize

def calculate_prize(exp_list, exp_tuple):    
    for exp in exp_tuple:
        i = 1
        while i < len(exp_list):
            if exp == exp_list[i]:    
                new_num = 0
                if exp == '*':
                    new_num = exp_list[i - 1] * exp_list[i + 1]
                elif exp == '-':
                    new_num = exp_list[i - 1] - exp_list[i + 1]                    
                elif exp == '+':
                    new_num = exp_list[i - 1] + exp_list[i + 1]
                exp_list = exp_list[:i - 1] + [new_num] + exp_list[i+2:]      
                continue
            i += 1        
    return abs(exp_list[0])
                    
                    