function solution(m, n, puddles) {    
    
    // 물웅덩이 검사 set 생성
    const puddle_set = new Set([])
    
    for (const [pcol, prow] of puddles) {
        puddle_set.add(`${prow - 1},${pcol - 1}`)
    }        
    
    function is_puddle(row, col) {
        const puddle_key = `${row},${col}`
        return puddle_set.has(puddle_key)        
    }
    
    // dp 배열 선언
    const dp = Array.from({length : n}, () => Array(m).fill(0));
    
    dp[0][0] = 1;
    
    // 오른쪽
    for (let i = 1; i < m; i++) {
        dp[0][i] = is_puddle(0, i) ? 0 : dp[0][i - 1];
    }
    
    // 아래쪽
    for (let i = 1; i < n; i++) {
        dp[i][0] = is_puddle(i, 0) ? 0 : dp[i - 1][0];
    }
        
    for (let i = 1; i < n; i++) {
        for (let j = 1; j < m; j++) {
            if (is_puddle(i, j)) {
                dp[i][j] = 0
            } else {
                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 1000000007
            }            
        }
    }    
    
    return dp[n - 1][m - 1] % 1000000007;
}
    