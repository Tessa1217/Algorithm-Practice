function solution(babbling) {
    var answer = 0;
    const can_bable_word = ["aya", "ye", "woo", "ma"]
    for (let bable of babbling) {        
      
        for (let j = 0; j < can_bable_word.length; j++) {
            if (bable.includes(can_bable_word[j].repeat(2))) {
                break;
            }
                    
            bable = bable.split(can_bable_word[j]).join(" ")    
        }
        
        if (bable.split(" ").join("").length === 0) {
            answer += 1
        }
        
    }
    return answer;
}   


