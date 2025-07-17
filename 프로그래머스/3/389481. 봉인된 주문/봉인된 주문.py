def solution(n, bans):
    answer = ''
    alphabet = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z']
    
    # 잃어버린 주문의 인덱스 배열
    lost_magic = []
    for lost in bans:
        lost_magic.append(find_letter_index(lost))                
    
    # 잃어버린 주문의 인덱스 배열
    lost_magic.sort()
    
    for l in lost_magic:     
        if l > n:
            break
        n += 1
    
    return find_magic_at_index(alphabet, n)

# 특정 문자의 사전적 인덱스 찾기
def find_letter_index(letter):
    idx = 0
    digit = 0
    for i in range(len(letter) - 1, -1, -1):        
        idx += ((ord(letter[i]) % 97) + 1) * (pow(26, digit))
        digit += 1  
    return idx
    

# 특정 인덱스의 문자 찾기
# 27 -> 28 -> 29 -> 30 -> 31
# (27 + 0) -> (27 + 1) -> (27 + 2)
# aa -> ab -> ac -> ad -> ae
def find_magic_at_index(alphabet, index):
    alphabet_length = 26
    character = ''
    while index > 0:        
        character = alphabet[(index - 1) % 26] + character        
        # 위치가 z라면
        if index % 26 == 0:
            index = index - 1            
        index //= 26
    return character