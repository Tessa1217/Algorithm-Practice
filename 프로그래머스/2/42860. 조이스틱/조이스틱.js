// const alpha = ['A', 'B', 'C', 'D', E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z]
//  AAA에서 JAN을 만든다면
// J 완성 => 9번
// 좌측으로 커서 이동 => 1번
// N을 완성 => 13번 

// AAAAAA에서 JEROEN 만든다면
// J완성 => 9번
// 우측으로 한 칸 이동 => 1번
// E완성 => 4번
// 우측으로 한 칸 이동 => 1번
// R로 만들기 => 9번
// 우측으로 한 칸 이동 => 1번
// O로 만들기 => 12번
// 우측으로 한 칸 이동 => 1번
// E완성 => 4번
// 우측으로 한 칸 이동 => 1번
// N완성 => 13번
// 9 + 1 + 4 + 1 + 9 + 1 + 12 + 1 + 4 + 1 + 13 => 56번
function solution(name) {
    
    const length = name.length
    // 완성된 이름
    const complete_name = name.split("").map((n) => n.charCodeAt())    
    // 시작 array ('A'로 시작)
    const array = Array.from({length}, () => 65)
    
    // 현재 인덱스
    let max_move = length - 1
    // 조작 움직임
    let cnt = 0;
    
    for (let i = 0; i < length; i++) {
        
        const target = complete_name[i]
        cnt += Math.min(target - 65, 90 - target + 1)
        
        let next_a = i + 1;
        while (next_a < length && complete_name[next_a] === 65) {
            next_a++
        }
        
        max_move = Math.min(max_move, (i + i) + length - next_a)
        max_move = Math.min(max_move, (length - next_a) * 2 + i)
    }
    
    return cnt + max_move;
}