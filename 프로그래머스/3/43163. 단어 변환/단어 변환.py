from collections import deque

def solution(begin, target, words):
                    
    # 단어를 바꿀 수 있는 조건
    # 현재 단어에는 한 자리 수만 변경 가능
    # words에 있는 단어만 사용 가능
    def search(begin, target, words):        
        
        queue = deque([(begin, 0)])
        visited = dict(zip(words, [False for _ in range(len(words))]))        
        possible_letter = set(char for word in words for char in word)

        while queue:
            
            (cur_word, cnt) = queue.popleft()                     
            
            # hit일 때 바꿀 수 있는 경우
            # hi?, h?t, ?it 3가지
            for i in range(len(cur_word)):
                for char in possible_letter:
                    cur_word_letter = list(cur_word)                    
                    cur_word_letter[i] = char                    
                    change_word = "".join(cur_word_letter)                    
                    if change_word == target:
                        return cnt + 1
                    if change_word in words and not visited[change_word]:
                        queue.append((change_word, cnt + 1))
                        visited[change_word] = True
        return 0
                

    # target이 단어 집합에 없는 경우에는 변환 불가능
    if target not in words:
        return 0
    
    return search(begin, target, words)
                                