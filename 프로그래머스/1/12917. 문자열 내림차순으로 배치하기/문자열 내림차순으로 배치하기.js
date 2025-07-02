function solution(s) {    
    return s.split('').sort((s1, s2) => s2.charCodeAt() - s1.charCodeAt()).join("");
}