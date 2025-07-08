const fs = require("fs");
const input = fs.readFileSync('/dev/stdin').toString().trim().split("\n");

let n =  input[0];
// 용액 배열 세팅 및 합을 찾기 윟나 오름차순 정렬
let arr = input[1].split(" ").map((i) => Number(i)).sort((a, b) => a - b);

function find_close_to_zero(arr, n) {
    let start = 0;
    let end = n - 1;
    let close_to_zero_sum = Number.MAX_VALUE;
    let answer = "";
    
    while (start < end) {
        let sum = arr[start] + arr[end];
        
        if (sum === 0) {
            answer = `${arr[start]} ${arr[end]}`;
            break;
        }
        
        if (close_to_zero_sum > Math.abs(sum)) {
            close_to_zero_sum = Math.abs(sum);
            answer = `${arr[start]} ${arr[end]}`;
        }
        
        if (sum > 0) {
            end--;
        } else {
            start++;
        }
    }
    
    console.log(answer);
}

find_close_to_zero(arr, n);
