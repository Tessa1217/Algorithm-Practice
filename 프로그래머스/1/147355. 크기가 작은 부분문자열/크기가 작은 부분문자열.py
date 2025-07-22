def solution(t, p):
    answer = 0
    sub_str_length = len(p)
    str_length = len(t)
    for i in range(str_length - sub_str_length + 1):
        if int(t[i:i + sub_str_length]) <= int(p):
            answer += 1
    return answer