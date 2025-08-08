function solution(answers) {
    var answer = Array.from({length : 3}).fill(0);
    
    const give_up_a = [1, 2, 3, 4, 5]
    const give_up_b = [2, 1, 2, 3, 2, 4, 2, 5]
    const give_up_c = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]
    
    answers.forEach((a, idx) => {
        answer[0] += give_up_a[idx % give_up_a.length] === a ? 1 : 0
        answer[1] += give_up_b[idx % give_up_b.length] === a ? 1 : 0
        answer[2] += give_up_c[idx % give_up_c.length] === a ? 1 : 0        
    })
    
    const max_score = answer.reduce((max_cnt, cnt) => Math.max(max_cnt, cnt), 0)
    
    const max_tester = []
    
    for (let i = 0; i < answer.length; i++) {
        if (max_score === answer[i]) {
            max_tester.push(i + 1)
        }
    }
    
    return max_tester
                 
}