function solution(score) {
    var answer = [];
    const avg = score.map(([eng, math]) => (eng + math) / 2)
    const sorted = avg.slice().sort((a, b) => b - a)
    return avg.map(a => sorted.indexOf(a) + 1);
}