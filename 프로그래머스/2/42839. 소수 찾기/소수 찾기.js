function solution(numbers) {    
    const possible = [...getAllPermutations(numbers.split(""))]
    return possible.filter((targetNumber) => checkPrimeNumber(targetNumber)).length;
}

// 소수 판별하기
const checkPrimeNumber = (num) => {
    if (typeof num === 'string') {
        num = Number.parseInt(num)
    }
    
    if (num < 2) {
        return false
    }    
    
    for (let i = 2; i <= Math.sqrt(num); i++) {
        if (num % i === 0) {
            return false
        }
    }
    return true
}

// 조합 구하기
const getAllPermutations = (arr) => {
    
    const result = []
    
    // 전체 경우의 수 구하기 위해서 나올 수 있는 자리별 경우의 수 구하기
    function getPermutations(arr, r) {
        
        const permutes = []
        
        function permute(current, used) {
            // 탈출 조건
            if (current.length === r) {
                permutes.push([...current])
                return
            }
            
            for (let i = 0; i < arr.length; i++) {
                if (used[i]) continue
                used[i] = true
                current.push(arr[i])
                permute(current, used)
                current.pop()
                used[i] = false
            } 
        }  
        
        permute([], Array.from({length:arr.length}).fill(false))
        
        return permutes
    }
    
    for (let i = 1; i <= arr.length; i++) {
        const permutePerLength = getPermutations(arr, i)        
        result.push(...permutePerLength.map((p) => Number.parseInt(p.join(""))))
    }
    
    return new Set(result)
}