// 한 사람이 가진 카드들에 모든 숫자를 나눌 수 있다 => 모든 수의 공약수
// 다른 사람이 가진 카드들에 적힌 모든 숫자를 나눌 수 없다
function solution(arrayA, arrayB) {
    var answer = 0;
    
    const arrayADivisors = getDivisorsOfCards(arrayA)
    const arrayBDivisors = getDivisorsOfCards(arrayB)
    
    
    const arrayANonDivisor = getMaxNonDivisor(arrayA, arrayBDivisors)
    const arrayBNonDivisor = getMaxNonDivisor(arrayB, arrayADivisors)    
    
    return Math.max(arrayANonDivisor, arrayBNonDivisor);
}

// 카드에 대해 조건을 만족하는 가장 큰 양의 정수 구하기
function getMaxNonDivisor(array, divisors) {
    let nonDivisor = 0
    for (let i = 0; i < divisors.length; i++) {
        let divisor = divisors[i];
        if (divisor === 1) {
            continue
        }
        for (let j = 0; j < array.length; j++) {
            if (array[j] % divisor === 0) { // 나눌 수 있는 수라면 더 보지않고 break                
                divisor = 0                
                break                
            }
        }        
        nonDivisor = Math.max(nonDivisor, divisor)        
    }
    return nonDivisor
}

// 숫자 카드 전체의 공약수 구하기
function getDivisorsOfCards(array) {
    const gcdOfArray = array.slice(1).reduce((a, b) => gcd(Math.min(a, b), Math.max(a, b)), array[0])
    return getDivisors(gcdOfArray)
}

// 최대공약수의 약수 구하기
function getDivisors(num) {
    const result = []
    for (let i = 1; i <= Math.sqrt(num); i++) {
        if (num % i === 0) {
            result.push(i)
            result.push(num / i)
        }
    }
    return result
}

// 유클리드 호제법을 통해 수의 최대 공약수 찾기
function gcd(a, b) {
    if (b == 0) {
        return a;
    }
    return gcd(b, (a%b))
}