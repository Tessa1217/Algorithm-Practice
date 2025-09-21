function solution(n, info) {    
    
    // 라이언이 획득할 수 있는 양궁 배열 구하기
    const ryans = [];
    
    // idx => 현재 과녁 인덱스
    // cur => 현재 과녁 정보
    // left => 남은 화살 개수
    function dfs(idx, cur, left) {
        
        // 탈출 조건 : 화살이 한 발도 남지 않았거나, 마지막 과녁인 경우
        if (left === 0 || idx === info.length) {
            if (left > 0) cur[info.length - 1] += left
            ryans.push([...cur])
            if (left > 0) cur[info.length - 1] -= left // 초기화
            return
        }
        
        // 어피치를 이기기 위해서는 현재 과녁 인덱스보다 1개 더 쏘아야 점수 획득 가능
        const cnt_to_win = info[idx] + 1
        if (left - cnt_to_win >= 0) {
            cur[idx] = cnt_to_win
            dfs(idx + 1, cur, left - cnt_to_win)
            // 초기화
            cur[idx] = 0            
        }        
        
        // 현재 과녁에서 점수 안 얻는다면 아예 안 쏘면 됨
        dfs(idx + 1, cur, left)
    }
    
    const info_length = info.length;
    const ryan_info = Array.from({length : info_length}).fill(0)
    
    dfs(0, ryan_info, n)
    
    return check_score(ryans, info, info_length)
}

function check_score(ryans, apeach, length) {
    
    // 최고의 점수 차
    let best_score_gap = -1
    let best_score_arr = null
    
    ryans.forEach((ryan) => {
        // 화살 비교
        // 어피치가 더 많이 맞췄거나 똑같이 맞췄다면 => 어피치가 점수 획득
        // 라이언이 더 많이 맞춘 경우 => 라이언이 점수 획득
        // 둘 다 0개 맞춘 과녁이라면 => 둘다 해당 과녁에 대한 점수 얻지 못함
        let ryan_score = 0
        let apeach_score = 0
        for (let i = 0; i < length; i++) {
            if (ryan[i] === 0 && apeach[i] === 0) {
                continue
            }
            if (ryan[i] > apeach[i]) {
                ryan_score += 10 - i                
            } else {
                apeach_score += 10 - i
            }
        }
        
        const score_gap = ryan_score - apeach_score
        
        // 라이언이 우승하지 못하는 경우: 점수차가 같거나 어피치가 더 높은 경우
        if (score_gap <= 0) {
            return
        }
        
        // 라이언의 최종 점수가 똑같은 경우에는 => 가장 낮은 점수를 더 많이 맞힌 경우를 return
        if (best_score_gap < score_gap) {
            best_score_gap = score_gap
            best_score_arr = [...ryan]
        } else if (best_score_gap === score_gap) {
            for (let i = length - 1; i >= 0; i--) {
                if (best_score_arr[i] === ryan[i]) {
                    continue
                }
                if (best_score_arr[i] < ryan[i]) {
                    best_score_arr = [...ryan]
                }
                break;
            }
        }
    })
    
    if (best_score_gap === -1) {
        return [-1]
    }
    return best_score_arr
}