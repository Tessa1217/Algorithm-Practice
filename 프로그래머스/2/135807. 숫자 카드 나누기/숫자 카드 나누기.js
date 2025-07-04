// 한 사람이 가진 카드들에 모든 숫자를 나눌 수 있다 => 모든 수의 공약수
// 다른 사람이 가진 카드들에 적힌 모든 숫자를 나눌 수 없다
function solution(arrayA, arrayB) {    

    const arrayAGcd = getGcdOfCards(arrayA)
    const arrayBGcd = getGcdOfCards(arrayB)    
    
    return Math.max(getMaxNonDivisor(arrayB, arrayAGcd), getMaxNonDivisor(arrayA, arrayBGcd));
}

// 최대 공약수가 다른 사람의 카드를 나눌 수 없는지 여부 판단하여 
// 상대방 카드 나눌 수 없는 최대 수 구하기
function getMaxNonDivisor(array, gcd) {    
    return array.every((a) => a % gcd !== 0) ? gcd : 0    
}

// 숫자 카드의 최대 공약수 구하기
function getGcdOfCards(array) {
    return array.reduce((a, b) => gcd(Math.min(a, b), Math.max(a, b)))
}

// 유클리드 호제법을 통해 두 수의 최대 공약수 찾기
function gcd(a, b) {
    if (b == 0) {
        return a;
    }
    return gcd(b, (a%b))
}