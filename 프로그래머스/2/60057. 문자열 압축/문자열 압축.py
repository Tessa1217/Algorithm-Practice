def solution(s):
    min_length = len(s)
    
    for i in range(1, len(s)):
        sub_strings = []
        for j in range(0, len(s), i):
            sub_strings.append(s[j : j + i])
        
        max_cnt = 1
        prev_str = sub_strings[0]
        input = ''
        
        for j in range(1, len(sub_strings)):
            if prev_str == sub_strings[j]:
                max_cnt += 1
            else:
                if max_cnt > 1:
                    input += str(max_cnt) + prev_str
                else:
                    input += prev_str
                max_cnt = 1
            prev_str = sub_strings[j]
            
        if max_cnt > 1:
            input += (str(max_cnt) + prev_str)
        else:
            input += prev_str        
            
        min_length = min(min_length, len(input))
        
    return min_length