function solution(rectangle, characterX, characterY, itemX, itemY) {
    var answer = 0;
    const area = mark_rectangle(rectangle)
    
    // scale
    characterY *= 2
    characterX *= 2
    itemX *= 2
    itemY *= 2
    
    const queue = [[characterY, characterX, 0]]
    const visited = Array.from({length: 101}, () => Array(101).fill(false));
    visited[characterY][characterX] = true
    
    const dirs = [[1, 0], [-1, 0], [0, 1], [0, -1]]
    while (queue.length) {
        const [r, c, depth] = queue.shift()        
        for (let [dr, dc] of dirs) {
            const nr = r + dr 
            const nc = c + dc 
            
            if (nr === itemY && nc === itemX) {                
                return Math.ceil(depth / 2)
            }            
            if (is_range(nr, nc)) {                              
                if (area[nr][nc] === 1 && !visited[nr][nc]) {                    
                    queue.push([nr, nc, depth + 1])
                    visited[nr][nc] = true
                }
            }
        }
    }
    return answer;
}

// 지형 마킹
// 좌표를 2배로 계산하여 border가 1픽셀 단위로 계산했을 때 겹쳐지는 문제 보완 (2배 스케일링)
function mark_rectangle(rectangles) {
    
    const area = Array.from({length: 101}, () => Array(101).fill(-1));  

    rectangles.forEach(rect => {
        let [x1, y1, x2, y2] = rect.map(v => v * 2); // 2배 스케일
        
        // 외부는 -1, 내부는 0, 테두리는 1
        for (let i = y1; i <= y2; i++) {
            for (let j = x1; j <= x2; j++) {
                if (i === y1 || i === y2 || j === x1 || j === x2) {
                    if (area[i][j] === -1) {
                        area[i][j] = 1
                    }
                } else {
                    area[i][j] = 0
                }                                
            }
        }
    });

    return area;    
}
 

// 좌표 범위 내인지 확인
function is_range(r, c) {
    return 0 <= r && r <= 100 && 0 <= c && c <= 100
}
