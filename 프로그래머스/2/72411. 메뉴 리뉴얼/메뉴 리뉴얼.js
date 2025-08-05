function solution(orders, course) {
    var answer = [];
    const cnt_map = new Map(course.map((c) => [c, 0]))    
    const menu_map = {}
    for (let c of course) {
        orders.forEach((order) => {
            const menu_order = order.split("")
            menu_order.sort()
            combination(menu_order, c).forEach((comb) => {
                const comb_key = comb.join("")
                menu_map[comb_key] = (menu_map[comb_key] || 0) + 1    
                cnt_map.set(c, Math.max(cnt_map.get(c), menu_map[comb_key]))                
            })
        })
    }
    
    Object.entries(menu_map).forEach(([key, value]) => {        
        if (value >= 2 && cnt_map.get(key.length) === value) {
            answer.push(key)
        }
    })
    
    answer.sort()
        
    return answer;
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