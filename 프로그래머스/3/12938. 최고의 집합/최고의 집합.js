function solution(n, s) {
    
    // 조건 만족 불가능
    if (n > s) return [-1];
    
    // 곱 최대화하는 방법은 => 가능한 모든 수가 동일할 때 (집합 내 요소 간의 차가 최소화일 때)
    // { 1, 8 }, { 2, 7 }, { 3, 6 }, { 4, 5 }
    // 8, 14, 18, 20 (최대 곱)
    const mid = Math.floor(s / n)
    const remainder = s % n;
    
    const greatSet = Array(n).fill(mid);    
    // console.log(greatSet, remainder)
    
    for (let i = 0; i < remainder; i++) {
        greatSet[n - 1 - i] += 1;
    }    
    
    // console.log(greatSet)
            
    return greatSet;
}
