function solution(s) {
    var answer = 0;
    
    const parenthesis = s.split("")
    
    const length = parenthesis.length
    let turn = 0
    
    while (turn < length) {
        answer += valid_parentheses(parenthesis) ? 1 : 0
        parenthesis.push(parenthesis.shift())        
        turn++
    }
    
    
    return answer;
}

function valid_parentheses(parentheses) {
    const parenthesis_stack = []
    for (const p of parentheses) {
        if ("[{(".includes(p)) {
            parenthesis_stack.push(p)
            continue
        }
        if (parenthesis_stack.length === 0) return false
        if (parenthesis_stack.at(-1) === find_pair(p)) {
            parenthesis_stack.pop()
        }        
    }
    return parenthesis_stack.length === 0
}

// 짝 찾기
function find_pair(parenthesis) {
    if (parenthesis === ']') {
        return '['
    }
    if (parenthesis === '}') {
        return '{'
    }
    if (parenthesis === ')') {
        return '('
    }
}