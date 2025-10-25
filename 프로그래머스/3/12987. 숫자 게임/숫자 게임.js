function solution(A, B) {
    
    // 최대 승점 구하기 - 승점 조합 구하는 문제는 아님
    const length = A.length
    
    if (length === 1) {
        return B[0] > A[0] ? 1 : 0
    }
        
    A.sort((a, b) => b - a);
    B.sort((a, b) => a - b);
    
    // n제곱은 통과 X => 효율성 테스트 실패
    // O(n)으로 줄인다면?
     
    for (let i = 0; i < length; i++) {
        // console.log(A[i], B[B.length - 1])
        if (A[i] < B[B.length - 1]) {
            B.pop()            
        }
    }
    
    return length - B.length
}