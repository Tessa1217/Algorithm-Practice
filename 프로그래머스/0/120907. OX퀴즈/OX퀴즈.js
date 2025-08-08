function solution(quiz) {
    var answer = [];
    for (let formula of quiz) {
        answer.push(check_valid_formula(formula) ? 'O' : 'X')
    }
    return answer;
}

function check_valid_formula(formula) {
    const [num1, operator, num2, equal, answer] = formula.split(" ")
    return calculate(num1, operator, num2) === Number.parseInt(answer)
}

function calculate(num1, operator, num2) {
    switch (operator) {
        case "+" : 
            return Number.parseInt(num1) + Number.parseInt(num2)
        case "-" :
            return Number.parseInt(num1) - Number.parseInt(num2)
        default:
            return null
    }
}