// 한 사람이 가진 카드들에 모든 숫자를 나눌 수 있다 => 모든 수의 공약수
// 다른 사람이 가진 카드들에 적힌 모든 숫자를 나눌 수 없다
function solution(arrayA, arrayB) {    

    const arrayANonDivisor = getMaxNonDivisor(arrayA, getDivisorsOfCards(arrayB))
    const arrayBNonDivisor = getMaxNonDivisor(arrayB, getDivisorsOfCards(arrayA))    
    
    return Math.max(arrayANonDivisor, arrayBNonDivisor);
}

// 카드에 대해 조건을 만족하는 가장 큰 양의 정수 구하기
function getMaxNonDivisor(array, divisors) {
    
    // 나눌 수 있는 수 판별                
    const canDivide = (array, divisor) => array.find((element) => element % divisor === 0)
    
    return divisors.reduce((accum, divisor) => {
        if (canDivide(array, divisor) === undefined) {
            accum = Math.max(accum, divisor)
        }    
        return accum
    }, 0)
    
    return maxNonDivisor
    
}

// 숫자 카드 전체의 공약수 구하기
function getDivisorsOfCards(array) {
    const gcdOfArray = array.reduce((a, b) => gcd(Math.min(a, b), Math.max(a, b)))
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