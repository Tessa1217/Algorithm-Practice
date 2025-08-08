function solution(a, b) {    
    // 정수도 유한소수
    if (a % b === 0) {
        return 1
    }    
    const denom = b / gcd(a, b)        
    return can_divide_with_two_or_five(denom) ? 1 : 2;
}

function can_divide_with_two_or_five(num) {
    while (num !== 1) {
        if (num % 2 !== 0 && num % 5 !== 0) {
            return false
        }        
        num = num % 2 === 0 ? num / 2 : num / 5
    }
    return true
}

function gcd(a, b) {
    return (a % b) === 0 ? b : gcd(b, a % b)
}