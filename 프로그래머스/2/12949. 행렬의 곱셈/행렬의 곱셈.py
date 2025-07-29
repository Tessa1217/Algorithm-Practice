def solution(arr1, arr2):
    answer = [[0 * i for i in range(len(arr2[0]))] for j in range(len(arr1))]
    
    print(answer)
    
    # (0, 0) => (0, 0) * (0, 0) + (0, 1) * (1, 0) + (0, 2) * (2, 0)
    # (0, 1) => (0, 0) * (1, 0) + (0, 1) * (1, 1) + (0, 2) * (2, 1)
    # (0, 2) => (0, 0) * (2, 0) + (0, 1) * (2, 1) + (0, 2) * (2, 2)
    
    # (1, 0) => (1, 0) * (0, 0) + (1, 1) * (1, 0) + (1, 2) * (2, 0)
    # (1, 1) => (1, 0) * (1, 0) + (1, 1) * (1, 1) + (1, 2) * (2, 1)
    # (1, 2) => (1, 0) * (2, 0) + (1, 1) * (2, 1) + (1, 2) * (2, 2)
    
    for i in range(len(arr1)):        
        for j in range(len(arr2[0])):            
            for k in range(len(arr1[0])):
                answer[i][j] += arr1[i][k] * arr2[k][j]                
        
                
    return answer
                