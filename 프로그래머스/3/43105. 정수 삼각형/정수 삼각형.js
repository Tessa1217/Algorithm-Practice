function solution(triangle) {
    
    // 위에서 밑으로 더하는 방식으로 풀이 시 시간 초과 발생
    // 밑에서 위로 더하는 방식
    // 직각 삼각형 방향으로 봤을 때 더할 수의 방향은?
    // 바로 하위 요소 (x + 1, y) 또는 대각선 오른쪽 방향 요소 (x + 1, y + 1)
    const dirs = [[1, 0], [1, 1]]
    const mr = triangle.length
    
    for (let i = mr - 2; i >= 0; i--) {
        for (let j = 0; j < triangle[i].length; j++) {                          
            triangle[i][j] += Math.max(triangle[i + dirs[0][0]][j + dirs[0][1]], triangle[i + dirs[1][0]][j + dirs[1][1]])
        }
    }
    
    return triangle[0][0];
}