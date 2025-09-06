function solution(info, edges) {

    var answer = 0;
    
    const tree_map = new Map()
    for (const edge of edges) {
        if (!tree_map.has(edge[0])) tree_map.set(edge[0], [])        
        tree_map.get(edge[0]).push(edge[1])        
    }
    
    function backtrack(curSheep, curWolf, available) {
        // 더는 방문할 노드가 없다면
        if (available.length === 0) {
            answer = Math.max(curSheep, answer)
            return;
        }
        for (let i = 0; i < available.length; i++) {
            const node = available[i]
            const nextSheep = curSheep + (info[node] === 0 ? 1 : 0)
            const nextWolf = curWolf + (info[node] === 1 ? 1 : 0)
            if (nextSheep <= nextWolf) continue
            answer = Math.max(answer, nextSheep)
            const next = [...available.slice(0, i), ...available.slice(i + 1)]
            if (tree_map.has(node)) next.push(...tree_map.get(node))     
            backtrack(nextSheep, nextWolf, next)            
        }
    }
    
    backtrack(0, 0, [0])   

    return answer;
        
}

