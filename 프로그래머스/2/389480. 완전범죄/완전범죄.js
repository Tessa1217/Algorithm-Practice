function solution(info, n, m) {
    
    let min_thief_a = Number.MAX_SAFE_INTEGER
    
    const visited_set = new Set()
    
    function dfs(idx, thief_a, thief_b) {          
        // 두 도둑 중 하나 이상이 흔적을 넘어 경찰에 잡힌 경우
        if (thief_a >= n || thief_b >= m) {
            return
        }
        // 이미 산출된 최소 값보다 도둑 A의 흔적 합이 큰 경우
        if (thief_a >= min_thief_a) {
            return
        }
        
        const visit_key = `${idx}_${thief_a}_${thief_b}`
        if (visited_set.has(visit_key)) {
            return
        }
        visited_set.add(visit_key)
        
        if (idx === info.length) {
            min_thief_a = Math.min(min_thief_a, thief_a)
            return
        }
        // A 도둑이 훔쳤을 때
        dfs(idx + 1, thief_a + info[idx][0], thief_b)
        // B 도둑이 훔쳤을 때
        dfs(idx + 1, thief_a, thief_b + info[idx][1])
    }
    
    dfs(0, 0, 0)
    
    return min_thief_a === Number.MAX_SAFE_INTEGER ? -1 : min_thief_a;
}