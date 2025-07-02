function solution(s) {
    
    return s.split(" ").map((word) => {
        return word.split("").map((c, idx) => idx % 2 === 0 ? c.toUpperCase() : c.toLowerCase()).join("")
    }).join(" ");    
}