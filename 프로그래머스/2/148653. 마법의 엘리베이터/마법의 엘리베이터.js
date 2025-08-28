function solution(storey) {
    let answer = 0;
    
    while (storey > 0) {
        const d = storey % 10;
        const next = Math.floor(storey / 10) % 10;
        
        // 버튼 한번은 10 ^ c 승만큼 이동
        // 어떤 자리의 숫자를 0으로 만드는 데 드는 비용을 비교
        // 내림 비용 (d) vs 올림 비용 (10 - d)
        
        // 5보다 작다면 내리는 게 이득
        if (d < 5) {
            answer += d;
            storey = Math.floor(storey / 10)
        } else if (d > 5) {
            // 5보다 크다면 다음 자릿수 맞추는 게 이득
            answer += (10 - d)
            storey = Math.floor(storey / 10) + 1 // 다음 자릿수 맞췄으니까 올림 처리
        } else {
            answer += 5;
            // 5인 경우에는 다음 계산을 고려해야함
            if (next >= 5) {
                // 다음이 5보다 크다면 올림 처리
                storey = Math.floor(storey / 10) + 1;
            } else {                                
                storey = Math.floor(storey / 10);
            }
        }
    }
    
    return answer;
}

