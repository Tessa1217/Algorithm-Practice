function solution(s) {    
    if (![4, 6].includes(s.length)) {
        return false
    }        
    for (let i = 0; i < s.length; i++) {
        if (isNaN(s[i])) {
            return false
        }
    }
    return true
}