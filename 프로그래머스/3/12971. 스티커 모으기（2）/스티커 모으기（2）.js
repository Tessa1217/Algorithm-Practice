function solution(sticker) {
    function collect_sticker(sticker) {
        let sticker1 = 0
        let sticker2 = 0
        for (const s of sticker) {
            const new_sticker = Math.max(sticker1 + s, sticker2)
            sticker1 = sticker2
            sticker2 = new_sticker            
        }
        return sticker2
    }
    
    const length = sticker.length
    if (length === 1) return sticker[0]
    return Math.max(collect_sticker(sticker.slice(0, length - 1)), collect_sticker(sticker.slice(1, length)))
}
