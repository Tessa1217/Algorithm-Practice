function solution(arr)
{
    return arr.reduce((a, b, idx, array) => {
       if (!idx || array[idx - 1] !== b) {
           a.push(b)
       }
       return a;
    }, [])
    
}