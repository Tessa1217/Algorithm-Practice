function solution(n) {    
    return (n + "").split("").map((c) => parseInt(c)).reverse();
}