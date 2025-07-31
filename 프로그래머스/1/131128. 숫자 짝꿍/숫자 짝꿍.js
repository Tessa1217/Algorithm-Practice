function solution(X, Y) {
    
    const x_number = generate_number_map(X);
    const y_number = generate_number_map(Y);

    const common_digits = [];

    for (let digit of x_number.keys()) {
        if (y_number.has(digit)) {
            const minCount = Math.min(x_number.get(digit), y_number.get(digit));
            for (let i = 0; i < minCount; i++) {
                common_digits.push(digit);
            }
        }
    }
    
    if (common_digits.length === 0) {
        return "-1";
    }    
    
    // 내림차순 정렬 (숫자 기준)
    common_digits.sort((a, b) => b - a);

    if (common_digits[0] === '0') {
        return "0"; // 모두 0으로만 구성된 경우
    }

    return common_digits.join('');
    
}

function generate_number_map(target_str) {
    return target_str.split("").reduce((map, value) => {
        map.set(value, (map.get(value) || 0) + 1)
        return map
    }, new Map())
}