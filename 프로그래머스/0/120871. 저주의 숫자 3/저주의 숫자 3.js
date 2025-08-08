function solution(n) {
    var answer = 0;
    for (let i = 1; i <= n; i++) {
        answer++
        while (answer.toString().includes('3') || answer % 3 === 0) {
            answer++
        }
        console.log(i, answer)
    }
    return answer;
}