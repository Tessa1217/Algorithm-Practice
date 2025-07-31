function solution(sizes) {
    var min_w = 0;
    var min_h = 0;
    for ([w, h] of sizes) {
        var temp = Math.max(w, h)
        w = Math.min(w, h)
        h = temp
        if (min_w < w) {
            min_w = w
        }
        if (min_h < h) {
            min_h = h
        }        
    } 
    return min_w * min_h;
}