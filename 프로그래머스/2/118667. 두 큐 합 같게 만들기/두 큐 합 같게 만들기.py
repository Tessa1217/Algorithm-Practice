# 생각한 문제 해결 흐름:
# 각 큐의 합을 구한다
# 합이 큰 큐에서 합이 작은 큐쪽으로 요소를 빼서 더한다
# 합이 같은지 여부를 비교한다
# 만약 두 개의 작업 모두 큐가 비었을 때까지 합을 구할 수 없다면 작업의 수행 결과를 -1로 반환

from collections import deque

def solution(queue1, queue2):
    
    queue1_sum = sum(queue1)
    queue2_sum = sum(queue2)   
    total_sum = queue1_sum + queue2_sum
    
    # 홀수라면 절대 같게 만들 수 없으므로 -1 리턴
    if total_sum % 2 != 0:
        return -1
    
    # 이미 두 큐의 합이 같은 경우라면
    if queue1_sum == queue2_sum:
        return 0        
    
    max_process_cnt = len(queue1) * 3
    q1, q2 = deque(queue1), deque(queue2)
    target = total_sum // 2
    process_cnt = 0
    i, j = 0, 0
    cur_sum = sum(q1)
    
    # 두 큐를 하나로 이어 붙인 것처럼 여김
    while process_cnt < max_process_cnt:
        if cur_sum == target:
            return process_cnt
        elif cur_sum > target:
            if q1:
                value = q1.popleft()
                cur_sum -= value
                q2.append(value)
            process_cnt += 1
        else:
            if q2:
                value = q2.popleft()
                cur_sum += value
                q1.append(value)
            process_cnt += 1
    
    return -1