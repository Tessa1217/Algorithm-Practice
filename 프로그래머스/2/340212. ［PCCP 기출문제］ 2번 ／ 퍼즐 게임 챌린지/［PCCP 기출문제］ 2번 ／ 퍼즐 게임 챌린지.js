function solution(diffs, times, limit) {
    
    // 현재 퍼즐의 난이도 = diff
    // 현재 퍼즐의 소요 시간 = time_cur
    // 이전 퍼즐의 소요시간 = time_prev
    // 현재 숙련도 = level
    
    // 2차 풀이: level을 min, max의 중간값으로 찾기
    let min_diff = 1;
    let max_diff = 100_000;    
    let level = 0;
    const m = diffs.length;
             
    while (min_diff <= max_diff) {        
        const mid = Number.parseInt((min_diff + max_diff) / 2)         
        if (can_pass_puzzle(mid)) {
            level = mid
            max_diff = mid - 1
        } else {
            min_diff = mid + 1
        }                
    }
    
    function can_pass_puzzle(cur_level) {
        let cur_limit = limit - times[0]
        for (let i = 1; i < m; i++) {
            const cur_diff = diffs[i]
            cur_limit -= calc_time(cur_level, cur_diff, times[i], times[i - 1]);
            if (cur_limit < 0) {
                return false
            }
        }
        return cur_limit >= 0
    }
    
    return level;
}

function calc_time(cur_level, cur_diff, cur_time, prev_time) {
    if (cur_level >= cur_diff) {
        return cur_time
    }
    return (cur_time + prev_time) * (cur_diff - cur_level) + cur_time
}