function solution(participant, completion) {
    
    // 참여자 맵 선언
    const map = new Map();
    
    for (let p of participant) {
        map.set(p, map.get(p) + 1 || 1);    
    }
    
    for (let cp of completion) {
        map.set(cp, map.get(cp) - 1);
    }
    
    return Array.from(map.entries()).filter(([key, value]) => value > 0).map(([key]) => key)[0];
    
}