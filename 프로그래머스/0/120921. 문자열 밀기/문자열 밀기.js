function solution(A, B) {
    
    if (A === B) {
        return 0
    }
    
    let idx = 0
    const a_arr = A.split("")        
    while (idx < A.length) {        
        a_arr.unshift(a_arr.pop())
        const new_word = a_arr.join("")
        idx++        
        if (new_word === B) {
            return idx
        }        
    }
    return -1;
}