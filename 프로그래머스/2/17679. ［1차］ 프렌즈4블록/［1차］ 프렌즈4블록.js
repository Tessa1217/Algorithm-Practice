function solution(m, n, board) {
    
    let block_cnt = 0
    
    // 2차원 배열로 변경
    board = board.map((b) => b.split(""))
    
    // 2 x 2 블록 확인용 배열
    // 우측, 우측 대각선, 아래측 확인
    const b_chk = [[0, 1], [1, 1], [1, 0]]
    
    // 삭제 가능한 2x2 블록 형태인지 확인
    function is_block_crashable(i, j) {
        return b_chk.every(([bi, bj]) => {
            const ni = i + bi
            const nj = j + bj
            if (!is_coord_in_range(ni, nj, m, n) || board[ni][nj] === '0') return false
            return board[i][j] === board[ni][nj]
        })
    }    
    
    while (true) {
        
        const result = []
        
        for (let i = 0; i < m; i++) {
            for (let j = 0; j < n; j++) {
                if (board[i][j] === '0') continue
                if (is_block_crashable(i, j, m, n)) {
                    result.push([i, j])
                    const blocks = b_chk.map(([bi, bj]) => ([i + bi, j + bj]))
                    result.push(...blocks)
                }
            }
        }
        
        if (result.length === 0) break
        const del_set = new Set(result.map(([a, b]) => `${a},${b}`))
        const del_block = [...del_set].map(s => s.split(",").map(Number))

        block_cnt += del_block.length
        
        del_block.forEach(([a, b]) => {
            board[a][b] = '0'
        })
        
        dropBlocks(m, n, board)
    }
    
    return block_cnt
}

// range 내에 있는지 확인
function is_coord_in_range(i, j, m, n) {
    return i >= 0 && j >= 0 && i < m && j < n
}


// 열 단위로 0으로 바뀐 삭제 블록 밑으로 내리기
function dropBlocks(m, n, blocks) {
    for (let j = 0; j < n; j++) {
        const remain_blocks = []
        for (let i = m - 1; i >= 0; i--) {
            if (blocks[i][j] !== '0') {
                remain_blocks.push(blocks[i][j])
            }
        }
        for (let i = m - 1; i >= 0; i--) {
            blocks[i][j] = remain_blocks.length > 0 ? remain_blocks.shift() : '0'
        }
    }   
}

