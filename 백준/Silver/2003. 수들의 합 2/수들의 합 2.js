const fs = require('fs')
const input = fs.readFileSync('/dev/stdin').toString().trim().split("\n")
let [n, m] = input[0].split(" ").map(Number);
let arr = input[1].split(" ").map(Number);

function find_target_case_cnt(arr, n, m) {
    let start = 0
    let end = 0
    
    // 수의 합
    let sum = 0
    
    // 수의 합 == target 카운드
    let cnt = 0
    
    while (end < n) {
        sum += arr[end];
        while (sum >= m) {
            if (sum === m) cnt++;
            sum -= arr[start]
            start++;
        }
        end++;
    }
    
    return cnt
}

console.log(find_target_case_cnt(arr, n, m))