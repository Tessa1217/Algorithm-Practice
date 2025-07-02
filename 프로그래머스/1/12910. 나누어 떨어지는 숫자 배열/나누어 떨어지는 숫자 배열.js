function solution(arr, divisor) {
    const dividedArr = arr.filter((val) => val % divisor === 0)
    return dividedArr.length ? dividedArr.sort((a, b) => a - b) : [-1];
}