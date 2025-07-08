const fs = require('fs')
const input = fs.readFileSync('/dev/stdin').toString().trim().split("\n")

// 전체 용액의 수 N
const n = Number(input[0])
// 용액 배열 (배열은 정렬이 된 상태)
const arr = input[1].split(" ").map(Number)

// 0에 가장 가까운 용액의 특성값 출력
function find_close_to_zero(arr, n) {
    // 투 포인터를 통해서 계산
    let start = 0;
    let end = n - 1;
    
    let close_to_zero_sum = Infinity
    
    let l1, l2;
    
    while (start < end) {
        let sum = arr[start] + arr[end]
        
        if (sum === 0) {
            l1 = arr[start];
            l2 = arr[end];
            break;
        }
        
        if (close_to_zero_sum > Math.abs(sum)) {
            close_to_zero_sum = Math.abs(sum);
            l1 = arr[start];
            l2 = arr[end];
        }
        
        if (sum > 0) {
            end--
        } else {
            start++
        }
    }
    
    return [l1, l2].join(" ")
    
}

console.log(find_close_to_zero(arr, n))