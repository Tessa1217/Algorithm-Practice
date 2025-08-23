function solution(numbers) {
    var answer = [];
    // 짝수면 끝이 0이니까 끝을 1로 바꾸면 될 듯...?
    for (const num of numbers) {
        if (num % 2 === 0) {
            answer.push(num + 1) 
        } else {
            const binary = num.toString(2)
            const last_zero = binary.lastIndexOf('0')
            // 전부다 1인 경우
            let result = '';
            if (last_zero === -1) {                
                result = '10' + binary.substring(0, binary.length - 1)
            } else {
                result = binary.substring(0, last_zero) + '10' + binary.substring(last_zero + 2)                 
            }
            answer.push(parseInt(result, 2))
        }
    }
    
    //  2 - 0010 => 3 // 짝수 : 다음 홀수
    //  3 - 0011 => 5 // 맨 앞의 숫자 1로, 그 다음 숫자 0으로
    //  4 - 0100 => 5 // 짝수 : 다음 홀수
    //  5 - 0101 => 6 // 마지막 0을 1로 바꾸기, 그 다음 수는 0으로 바꾸기
    //  6 - 0110 => 7 // 짝수 : 다음 홀수
    //  7 - 0111 => 11 // 맨 앞의 숫자 1로, 그 다음 숫자 0으로
    //  8 - 1000 => 9 // 짝수 : 다음 홀수
    //  9 - 1001 => 10 // 마지막 0을 1로 바꾸기, 그 다음 수는 0으로 바꾸기
    //  10 -1010 => 11 // 짝수 : 다음 홀수
    //  11 -1011
    
    return answer;
}