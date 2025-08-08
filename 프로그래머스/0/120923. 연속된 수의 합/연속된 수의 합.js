function solution(num, total) {
    var answer = [];
    // n + (n + 1) + (n + 2) = 3n + 3
    // 3 + 4 + 5 = 12
    
    // n + (n + 1) + (n + 2) + (n + 3) = 4n + 6
    // 2 + 3 + 4 + 5
    
    // n + (n + 1) + (n + 2) + (n + 3) + (n + 4) = 5n + 4!
    // -1 + 0 + 1 + 2 + 3 = 5
    // 5n + 10 = total
    
    const n = ((total - sum(num - 1)) / num)
    for (let i = 0; i < num; i++) {
        answer.push(n + i)
    }
    return answer;
}

function sum(n) {
    let num = 0;
    while (n > 0) {
        num += n--
    }
    return num
}