function solution(strings, n) {    
    strings.sort((str1, str2) => str1[n] === str2[n] ? str1.localeCompare(str2) : str1[n].localeCompare(str2[n]))
    return strings;
}