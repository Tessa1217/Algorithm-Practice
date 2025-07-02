function solution(a, b) {
    
    const dayMap = new Map([        
        [0, "SUN"],
        [1, "MON"],
        [2, "TUE"],
        [3, "WED"],
        [4, "THU"],
        [5, "FRI"],
        [6, "SAT"],        
    ])
    
    const day = new Date(`2016-${a}-${b}`).getDay();
    
    return dayMap.get(day);
}