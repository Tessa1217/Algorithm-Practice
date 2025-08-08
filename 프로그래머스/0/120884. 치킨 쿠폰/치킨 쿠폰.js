function solution(chicken) {
    var answer = 0;
    
    // 10장당 서비스 치킨 1마리를 시킬 수 있음
    while (chicken > 9) {
        const coupon = chicken % 10
        chicken = Math.floor(chicken / 10)        
        answer += chicken
        // 치킨 시키고 남은 쿠폰
        chicken += coupon        
    }
    return answer;
}