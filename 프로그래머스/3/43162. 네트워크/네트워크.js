function solution(n, computers) {
    var answer = 0;
    const visited = Array.from({length : n}, () => false)
    
    for (let i = 0; i < n; i++) {
        if (!visited[i]) {
            dfs(i)
            answer += 1
        }
    }
    
    function dfs(computer_idx) {
        visited[computer_idx] = true        
        for (let c = 0; c < n; c++) {
            if (!visited[c] && computers[computer_idx][c] == 1) {
                dfs(c)
            }
        }        
    }    
    
    return answer;
}6



