function solution(s) {    
    const mid = Math.floor(s.length / 2)
    // 4 / 2 => 2
    if (s.length % 2 === 1) {        
        return s[mid]
    }
    return s.slice(mid - 1, mid + 1);
}