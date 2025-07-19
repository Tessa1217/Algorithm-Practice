# 생각한 문제 해결 흐름:
# 각 큐의 합을 구한다
# 합이 큰 큐에서 합이 작은 큐쪽으로 요소를 빼서 더한다
# 합이 같은지 여부를 비교한다
# 만약 두 개의 작업 모두 큐가 비었을 때까지 합을 구할 수 없다면 작업의 수행 결과를 -1로 반환

from collections import deque

def solution(queue1, queue2):
    
    queue1_sum = get_sum_of_queue(queue1)
    queue2_sum = get_sum_of_queue(queue2)      
    
    # 이미 두 큐의 합이 같은 경우라면
    if queue1_sum == queue2_sum:
        return 0        
    
    return pop_and_insert_process(queue1, queue1_sum, queue2, queue2_sum)

def pop_and_insert_process(queue1, queue1_sum, queue2, queue2_sum):                
    q1, q2 = deque(queue1), deque(queue2)        
    process_cnt = 0

    # q1이 비지 않거나, q2가 비지 않거나, 최대 연산 횟수 (두 큐의 길이의 곱) 이하이면
    while q1 and q2 and process_cnt <= len(q1) + len(q2) + 1:

        if queue1_sum > queue2_sum:
            cur_element = q1.popleft()
            q2.append(cur_element)
            queue1_sum, queue2_sum = queue1_sum - cur_element, queue2_sum + cur_element
        else:
            cur_element = q2.popleft()
            q1.append(cur_element)
            queue1_sum, queue2_sum = queue1_sum + cur_element, queue2_sum - cur_element  
        process_cnt += 1

        if queue1_sum == queue2_sum:
            return process_cnt

    return -1

    

# 주어진 큐의 합을 구하기
def get_sum_of_queue(queue):
    sum = 0
    for element in queue:
        sum += element
    return sum