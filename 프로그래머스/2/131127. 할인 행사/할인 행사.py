def solution(want, number, discount):
    answer = 0        
    supplies = dict(zip(want, number));
    
    for i in range(len(discount)):
        discounted_supply = discount[i:i+10]
        all_covered = True
        for supply in supplies:            
            if discounted_supply.count(supply) < supplies[supply]:
                all_covered = False
                break
        if all_covered:
            answer += 1
        
    return answer