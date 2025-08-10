// n = 3
// 1 2 3
// 2 2 3
// 3 3 3
// 2 => 0번째 열에 2idx
// 3 => 1번째 열에 0idx
// 4 => 1번째 열에 1idx
// 5 => 1번째 열에 2idx

// n = 4
// 1 2 3 4
// 2 2 3 4
// 3 3 3 4
// 4 4 4 4
// 7 => 1번째 열에 3idx
// 8 => 2번째 열에 0idx
// 9 => 3번째 열에 1idx
// ...
function solution(n, left, right) {
    
    const answer = []
    
    for (let i = left; i <= right; i++) {
        // 열번호
        const row_idx = parseInt(i / n)
        // 행번호
        const col_idx = i % n
        // 시작 숫자
        const start_num = row_idx + 1
        // 열번호 밑의 행번호는 시작 숫자
        if (col_idx < row_idx) {
            answer.push(start_num)            
        } else {
            answer.push(start_num + col_idx - row_idx)
        }                
    }
    
    return answer
}