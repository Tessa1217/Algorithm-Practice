function solution(n) {
    var answer = 0;
    
    const col = Array.from(n).fill(0)
    
    function n_queens(col, i) {
        if (promising(col, i)) {
            if (i === n) {
                answer++
            } else {
                for (let j = 1; j <= n; j++) {
                    col[i + 1] = j
                    n_queens(col, i + 1)
                }                
            }
        }
    }
    
    n_queens(col, 0)
    
    return answer;
}

function promising(col, i) {
    let k = 1
    let flag = true
    while (k < i && flag) {
        if (col[i] === col[k] || Math.abs(col[i] - col[k]) === i - k) {
            flag = false
        }
        k++
    }
    return flag
}