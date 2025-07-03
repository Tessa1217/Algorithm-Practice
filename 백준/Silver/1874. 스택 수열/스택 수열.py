sequence = list()
n = int(input())

for _ in range(n):
    sequence.append(int(input()))
    
def stack_sequence(n, sequence):
    # 스택에 push하는 순서는 반드시 오름차순
    stack_seq = []
    # 연산자를 담기 위한 배열
    operators = []
    # 현재 처리된 수열의 인덱스
    sequence_index = 0
    
    for i in range(1, n + 1):
        stack_seq.append(i)
        operators.append('+')
        # 스택의 peek 부분과 현재 처리할 수열의 값을 비교
        while stack_seq and stack_seq[-1] == sequence[sequence_index]:
            stack_seq.pop()
            sequence_index += 1
            operators.append('-') # 두 수가 일치할 경우 pop
            
    if stack_seq:
        print("NO")
    else:
        for o in operators:
            print(o)

stack_sequence(n, sequence)            
    