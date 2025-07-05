function solution(s) {
    
    // 튜플은 원소의 순서가 정해져 있음
    // 튜플의 원소 순서는 리스트에서 길이가 짧은 원소 -> 길이가 긴 원소로 파악 가능
    // 집합은 원소의 순서가 바뀌어도 상관이 없음    
    const slist = s.split("{")
                   .filter(e => e)
                   .map(e => e.replaceAll("}", "").split(",").filter(e => e).map(e => parseInt(e)))
                   .sort((a, b) => a.length - b.length)
                   .flat(Infinity);           
    return [...new Set(slist)];    
    
}