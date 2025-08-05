function solution(orders, course) {
    var answer = [];
    
    // 코스 매뉴 맵
    const courseMenus = new Map()
    // 맵의 형태 Map(조합길이(코스메뉴 길이), Map(조합문자열, 등장횟수))
    for (let c of course) {
        courseMenus.set(c, new Map())
    }
    
    for (const order of orders) {
        // 원소에 저장된 문자열은 오름차순 정렬 필요
        const sortOrder = order.split("").sort()
        for (const c of course) {
            // 조합의 길이가 코스 메뉴보다 짧다면 조합 만들지 못하므로
            // continue 처리
            if (sortOrder.length < c) continue;
            for (const comb of combination(sortOrder, c)) {
                const menu = comb.join("")
                const menuMap = courseMenus.get(c)
                menuMap.set(menu, (menuMap.get(menu) || 0) + 1)
            }
        }
    }
    
    for (const [length, menuMap] of courseMenus.entries()) {
        // 코스 길이의 max 카운트
        const maxCount = Math.max(...menuMap.values(), 0)
        // 코스 요리는 2번 이상 주문되어야 구성 가능
        if (maxCount < 2) {
            continue
        }
        // 가장 많은 메뉴 구성은 여러 개일수 있음
        for (const [menu, count] of menuMap.entries()) {
            if (count === maxCount) {
                answer.push(menu)
            }
        }
    }
    
    return answer.sort();
}

function combination(arr, selectNumber) {
    if (selectNumber === 1) return arr.map((v) => [v])
    
    const results = []
    arr.forEach((value, index, origin) => {
        const rest = origin.slice(index + 1)
        const combs = combination(rest, selectNumber - 1)
        const attached = combs.map((c) => [value, ...c])
        results.push(...attached)
    })
    
    return results
}
