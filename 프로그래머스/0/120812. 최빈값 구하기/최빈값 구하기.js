function solution(array) {
    
    const frequency_map = array.reduce((accum, val) => {
        accum.set(val, (accum.get(val) || 0) + 1)
        return accum
    }, new Map())
    
    const max_frequency = [...frequency_map.values()].reduce((max, val) => max = Math.max(max, val), 0)    
    
    const frequent_num = [...frequency_map.entries()]
                                  .filter(([key, val]) => max_frequency === val)
                                  .map(([key, val]) => key)
    
    return frequent_num.length > 1 ? -1 : frequent_num[0];
}