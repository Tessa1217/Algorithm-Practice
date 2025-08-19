function solution(storage, requests) {
    
    const pos = [[0, 1], [0, -1], [1, 0], [-1, 0]]
    
    // 전체 개수
    let answer = storage.length * storage[0].length;    
    // padding 주기
    const container = padGrid(storage)
    const n = container.length;
    const m = container[0].length;    
    
    // 총 옮긴 개수
    let deleted = 0;
    for (let request of requests) {
        // 알파벳 2 = 크레인 - 요청과 같은 모든 컨테이너 꺼내기
        if (request.length === 2) {            
            deleted += takeAll(request[0])
        } else {
            // 알파벳 1 = 지게차 - 순간 접근 가능한 컨테이너 꺼내기
            deleted += takePossible(request)
        }
    }
    
    function takePossible(target) {
        const visited = Array.from({length : n}, () => Array(m).fill(false));
        const stack = [[0, 0]]
        visited[0][0] = true;
        // 중간에 바꾸면 오류 생길 수 있어서 지우는 목록 따로 모아두기
        const toDelete = []
        while (stack.length) {
            const [x, y] = stack.pop()
            for (const [mx, my] of pos) {
                const nx = mx + x
                const ny = my + y
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue
                if (visited[nx][ny]) continue
                
                const cell = container[nx][ny]
                if (cell === '0') {
                    visited[nx][ny] = true
                    stack.push([nx, ny])
                } else if (cell === target) {
                    visited[nx][ny] = true
                    toDelete.push([nx, ny])
                }
            }
        }        
        // 꺼내기 목록 마킹
        toDelete.forEach(([x, y]) => container[x][y] = '0')
        
        return toDelete.length
    }
    
    function takeAll(target) {
        let removed = 0;
        for (let i = 0; i < n; i++) {
            for (let j = 0; j < m; j++) {
                if (container[i][j] === target) {
                    container[i][j] = '0'
                    removed++
                }
            }
        }
        return removed
    }
    
    return answer - deleted;
}

function padGrid(grid) {
  const H = grid.length, W = grid[0].length;
  const padded = Array.from({ length: H + 2 }, (_, r) => {
    if (r === 0 || r === H + 1) return '0'.repeat(W + 2).split('');
    return ('0' + grid[r - 1] + '0').split('');
  });
  return padded; // 2차원 문자 배열
}