function solution(line) {
    var answer = [];
    
    // 두 선의 교점 구하기
    function find_point(formula1, formula2) {
        const [a, b, e] = formula1
        const [c, d, f] = formula2
        const denom = a * d - b * c
        if (a * d - b * c === 0) {
            return null
        }
        const x = (b * f - e * d) / denom
        const y = (e * c - a * f) / denom
        if (Number.isInteger(x) && Number.isInteger(y)) {
            return { x, y }
        }
        return null
    }
    
    const matrix = []
    
    for (let i = 0; i < line.length; i++) {
        for (let j = i + 1; j < line.length; j++) {
            const point = find_point(line[i], line[j])
            if (!point) {
                continue
            }
            matrix.push(point)          
        }
    }
    
    let minX = Infinity;
    let maxX = -Infinity;
    let minY = Infinity;
    let maxY = -Infinity;
    
    // x, y축 범위 지정하기
    matrix.forEach((point) => {
        minX = Math.min(minX, point.x)
        maxX = Math.max(maxX, point.x)
        minY = Math.min(minY, point.y)
        maxY = Math.max(maxY, point.y)
    })
    
    const grid = Array.from({length : maxY - minY + 1}, () => Array.from({length : maxX - minX + 1}, () => '.'))
    
    for (let {x, y} of matrix) {        
        grid[maxY - y][x - minX] = "*"
    }    
        
    return grid.map((row) => row.join(""));
}