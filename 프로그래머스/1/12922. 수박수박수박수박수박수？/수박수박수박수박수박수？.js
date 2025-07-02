function solution(n) {
    var answer = ''
    for (let i = 1; i <= n; i++) {
        answer += (i % 2 === 0 ? '박' : '수')
    }
    return answer;
}