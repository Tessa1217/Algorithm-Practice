function solution(numer1, denom1, numer2, denom2) {    
    // 분모 : 분모로 주어진 두 수의 최소공배수
    const cmd = (denom1 * denom2) / gcd(denom1, denom2)
    const numer_cnt = (cmd / denom1 * numer1) + (cmd / denom2 * numer2)    
    const gcd_of_denom_and_numer = gcd(cmd, numer_cnt)
    if (gcd_of_denom_and_numer === 1) {
        return [numer_cnt, cmd]
    }
    return [numer_cnt / gcd_of_denom_and_numer, cmd / gcd_of_denom_and_numer];
}

function gcd(a, b) {
    if (b === 0) {
        return a
    }
    return gcd(b, a % b)
}