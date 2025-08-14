function solution(cap, n, deliveries, pickups) {
    // 가장 먼 거리부터 이동하면서 택배 배달
    // 돌아오는 과정에서 수거
    var answer = 0;
    
    // 배달 포인터
    let d = n - 1;
    // 수거 포인터
    let c = n - 1;
    
    // 이미 수거 완료된 포인트는 스킵하기
    const skipFinishedSpot = () => {
        while (d >= 0 && deliveries[d] === 0) d--;
        while (c >= 0 && pickups[c] === 0) c--;
    }    
    
    // 배달 처리
    const processDelivery = (pointer, array) => {
        // 배달/수거 가능한 capacity 세팅
        let load = cap;
        while (load > 0 && pointer >= 0) {
            if (array[pointer] === 0) {
                pointer--
                continue
            }
            const process_cnt = Math.min(array[pointer], load);
            array[pointer] -= process_cnt;
            load -= process_cnt;
            if (array[pointer] === 0) {
                pointer--
            }
        }
    }
    
    // 첫 번째 거리 세팅
    skipFinishedSpot();
    
    // 배달 또는 수거 포인트가 남은 기간 동안
    while (d >= 0 || c >= 0) {
        const far = Math.max(d, c) + 1        
        answer += (far * 2);
        
        // 먼 곳에서부터 배달하기
        processDelivery(d, deliveries)
        
        // 먼 곳에서부터 수거하기
        processDelivery(c, pickups)
        
        skipFinishedSpot()
    }
    
    return answer;
}
