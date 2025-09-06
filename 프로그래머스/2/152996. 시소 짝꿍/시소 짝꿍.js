function solution(weights) {
    var answer = 0;
    // 시소 양쯕 축 무게 균형 가능한 경우만 고려
    const weight_map = weights.reduce((a, v) => {
        if (!a.has(v)) a.set(v, 0)
        a.set(v, a.get(v) + 1)
        return a
    }, new Map())    
    
    const possible_weight_ratio = [1/2, 2/3, 3/4]
    
    for (const [w, c] of weight_map) {
        // 무게가 같은 경우
        if (c >= 2) {
            answer += (c * (c - 1)) / 2
        }
        
        // 비율별 가능한 무게
        const ratio = possible_weight_ratio.map((r) => r * w).filter(Number.isInteger)
        
        for (const r of ratio) {
            if (weight_map.has(r)) answer += c * weight_map.get(r)
        }
        
    }
    
    return answer;
}