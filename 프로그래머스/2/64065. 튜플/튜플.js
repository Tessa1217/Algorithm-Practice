function solution(s) {
    
    const numberSet = []
    // 튜플은 원소에 정해진 순서가 존재
    for (let i = 0; i < s.length; i++) {
        if (!isNaN(s[i])) {
            let str = ''
            while (s[i] !== '}') {
                str += s[i];
                i++;
            }     
            const element = str.split(",");
            numberSet[element.length - 1] = element.map((s) => parseInt(s));            
        }       
    }    
    
    return numberSet.reduce((accum, ele) => {        
        accum.push(ele.find((e) => !accum.includes(e)));
        return accum
    }, [])    
    
}