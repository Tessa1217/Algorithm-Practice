function solution(polynomial) {    
    let x = 0
    let num = 0
    polynomial.split(" + ").forEach((v) => {
        if (v.includes('x')) {
            const poly = v.split("x")
            x += poly[0] ? Number(poly[0]) : 1
        } else {
            num += Number(v)
        }
    })
    
    if (x && num) {
        return `${x > 1 ? x : ''}x + ${num}`
    }
    return x ? `${x > 1 ? x : ''}x` : `${num}`;
}