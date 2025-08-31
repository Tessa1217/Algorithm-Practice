function solution(cacheSize, cities) {
    
    var answer = 0;
    
    // LRU 
    // 캐시 배열
    const cache = []
    
    for (c of cities) {
        const city = c.toUpperCase()
        const cache_idx = cache.indexOf(city)
        if (cache_idx === -1) {
            // cache miss
            answer += 5;
            cache.push(city)
            if (cache.length > cacheSize) {
                cache.shift()
            }            
        } else {
            // cache hit
            answer += 1;
            cache.push(cache.splice(cache_idx, 1)[0])            
        }          
    }
    
    
    return answer;
}