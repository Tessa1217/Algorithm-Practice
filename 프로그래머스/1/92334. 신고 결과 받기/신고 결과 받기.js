function solution(id_list, report, k) {
    var answer = Array.from({length : id_list.length}, () => 0)
    const { report_user_map, reported_cnt_map } = init(id_list)
    for (let r of report) {
        const [reporter, reportee] = r.split(" ")    
        // 이미 동일인이 신고했을 경우에는 신고 횟수 1회로 처리
        if (report_user_map.get(reporter).includes(reportee)) {
            continue
        }
        report_user_map.get(reporter).push(reportee);        
        reported_cnt_map.set(reportee, reported_cnt_map.get(reportee) + 1)
    }
    
    report_user_map.forEach((value, key) => {
        value.forEach((v) => {
            if (reported_cnt_map.get(v) >= k) {
                answer[id_list.indexOf(key)] += 1
            }
        })        
    })
    return answer;
}

function init(id_list) {
    // 신고한 유저 맵
    const report_user_map = new Map()
    // 신고당한 유저 횟수 맵
    const reported_cnt_map = new Map()
    
    for (let id of id_list) {
        report_user_map.set(id, [])
        reported_cnt_map.set(id, 0)
    }
    return {
        report_user_map,
        reported_cnt_map
    }
}