function solution(places) {
    var answer = Array.from({length : 5}, () => 1);
    for (let room_idx = 0; room_idx < 5; room_idx++) {
        const room = places[room_idx]
        const people = find_people_location(room)
        for (let i = 0; i < people.length; i++) {
            const [r1, c1] = people[i]
            for (let j = i + 1; j < people.length; j++) {
                const [r2, c2] = people[j]
                const distance = get_manhattan_distance(r1, c1, r2, c2)
                // 거리 2 이상은 맨하탄 거리 상 거리두기 시행 중
                if (distance > 2) {
                    continue
                }
                // 1 이하는 어디에 파티션을 놔두더라도 거리두기 시행 X
                if (distance <= 1) {
                    answer[room_idx] = 0;
                    break
                }
                if (!is_partition_blocking(r1, c1, r2, c2, room)) {
                    answer[room_idx] = 0;
                    break
                }
            }
        }
        
    }
    return answer;
}

function is_partition_blocking(r1, c1, r2, c2, room) {
    // 대각선이 아닌 경우
    if (r1 === r2 || c1 === c2) {
        const partition_r = r1 === r2 ? r1 : Number.parseInt((r1 + r2) / 2)
        const partition_c = c1 === c2 ? c1 : Number.parseInt((c1 + c2) / 2)                    
        if (room[partition_r][partition_c] !== 'X') {
            return false
        }
    } else {
        // 대각선인 경우에는 파티션이 좌측 사람의 우측에, 우측 사람의 좌측에 있어야 거리두기 가능
        const left_c = Math.min(c1, c2)
        const left_r = left_c === c1 ? r1 : r2
        const right_c = Math.max(c1, c2)
        const right_r = right_c === c1 ? r1 : r2
        if (room[left_r][left_c + 1] !== 'X' || room[right_r][right_c - 1] !== 'X') {
            return false
        }
    }    
    return true
}

// 대기실에서 사람 좌표 찾기
function find_people_location(room) {
    const people_location = []
    for (let i = 0; i < room.length; i++) {
        for (let j = 0; j < room[i].length; j++) {
            if (room[i][j] === 'P') {
                people_location.push([i, j])
            }
        }
    }
    return people_location
}

// 맨하탄 거리 구하기
function get_manhattan_distance(r1, c1, r2, c2) {
    return Math.abs(r1 - r2) + Math.abs(c1 - c2)
}