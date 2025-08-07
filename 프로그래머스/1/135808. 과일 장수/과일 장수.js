function solution(k, m, score) {
    var answer = 0;
    
    // 나올 수 있는 박스 개수 체크
    const box = Number.parseInt(score.length / m);    
    if (box === 0) return 0;
    
    // 숫자별 맵 생성
    const scoreMap = score.reduce((map, s) => {
        map[s] = (map[s] || 0) + 1
        return map
    }, {});
        
    let finished_box = 0
    let apple_in_box = 0
    while (k > 0 && finished_box < box) {
        if (!scoreMap[k]) {
            k--
            continue
        }                
        const box_made = Number.parseInt((scoreMap[k] + apple_in_box) / m)
        answer += box_made * k * m
        apple_in_box = (scoreMap[k] + apple_in_box) % m
        // console.log(k, apple_in_box)
        finished_box += box_made        
        k--        
    }
    
    
    
    return answer;
}