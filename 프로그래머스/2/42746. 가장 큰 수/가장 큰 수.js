function solution(numbers) {
    const answer = numbers.map(number => String(number))
                          .sort((a, b) => (b + a) - (a + b))
                          .join('');
    return answer[0] === '0' ? '0' : answer;
}