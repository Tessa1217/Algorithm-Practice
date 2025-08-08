function solution(brown, yellow) {
    // brown + yellow는 전체 카펫의 크기
    // 전체 카펫의 크기는 칸 개수의 약수 조합으로 구할 수 있음
    // yellow는 안에 들어가 있는 범위이므로 약수 x축 y축에서 각각 좌우, 상하 (2)씩 제거한 영역
    // 제거한 영역의 범위가 yellow의 칸과 같다면 카펫 크기
    const total_carpet = brown + yellow
    const possible_sizes = find_possible_sizes(total_carpet)
    return possible_sizes.filter(([x, y]) => (x - 2) * (y - 2) === yellow)?.[0]
}

function find_possible_sizes(size) {
    const result = []
    for (let i = 2; i <= Math.sqrt(size); i++) {
        if (size % i === 0) {
            result.push([Number.parseInt(size / i), i])
        }
    }
    return result
}