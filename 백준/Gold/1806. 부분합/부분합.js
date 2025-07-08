const fs = require('fs')
const input = fs.readFileSync('/dev/stdin').toString().trim().split("\n");

let [n, s] = input[0].split(" ").map(Number);

let arr = input[1].split(" ").map(Number);

function get_min_length_of_target_sequence(arr, n, s) {

    // 부분합 => 투 포인터 활용
    let start = 0;
    let end = 0;

    // 부분합
    let sum = 0;

    // 부분합의 최소 길이
    let min_length = Infinity;

    while (end < n) {
        // 현재 부분합이 target value 보다 작다면 끝쪽 포인터 이동
        sum += arr[end];

        while (sum >= s) {
            sum -= arr[start];
            min_length = Math.min(min_length, end - start + 1);
            start++;
        }

        end++;
    }

    // 부분합이 s와 맞지 않는다면 0을 출력
    if (min_length === Infinity) {
        min_length = 0;
    }

    console.log(min_length);
}

get_min_length_of_target_sequence(arr, n, s);

