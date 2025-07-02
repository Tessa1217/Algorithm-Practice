function solution(n)
{    
    return String(n).split("").reduce((a, b) => a + Number(b), 0)
}