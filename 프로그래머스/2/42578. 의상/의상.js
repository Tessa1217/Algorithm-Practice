function solution(clothes) {
    
    const clothesMap = new Map();
    
    for (let [clothe, type] of clothes) {
        clothesMap.set(type, clothesMap.get(type) + 1 || 1);        
    }
    
    const comb = Array.from(clothesMap.values()).reduce((a, b) => a * (b + 1), 1);
    
    return comb - 1;
    
}


