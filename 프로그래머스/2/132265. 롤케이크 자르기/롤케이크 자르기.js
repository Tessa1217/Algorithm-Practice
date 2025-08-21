function solution(topping) {
    var answer = 0;
    
    // 처음에는 모든 토핑이 철수 쪽에 있다고 가정
    const chulsoo = topping.reduce((a, v) => a.set(v, (a.get(v) || 0) + 1), new Map())
    const brother = new Set()
    
    // 토핑을 순차적으로 하나씩 chulsoo에서 제거하고 동생 쪽으로 옮긴다
    for (let t = 0; t < topping.length; t++) {
        const current_topping = topping[t]
        chulsoo.set(current_topping, chulsoo.get(current_topping) - 1)
        if (chulsoo.get(current_topping) === 0) chulsoo.delete(current_topping)
        brother.add(current_topping)
        if (brother.size === chulsoo.size) answer++        
    }
    
    return answer;
}