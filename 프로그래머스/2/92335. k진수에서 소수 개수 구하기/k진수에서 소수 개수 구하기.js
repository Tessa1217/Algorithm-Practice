function solution(n, k) {    
    const converted = n.toString(k).split("0")
    return converted.reduce((ans, val) => ans += is_prime(Number(val)) ? 1 : 0, 0);        
}

function is_prime(num) {
    if (num < 2) return false
    for (let i = 2; i * i <= num; i++) {
        if (num % i == 0) return false
    }
    return true
}