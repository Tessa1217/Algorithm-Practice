function solution(s){
    
    const str = s.toLowerCase();
    
    return str.split("p").length === str.split("y").length;
}