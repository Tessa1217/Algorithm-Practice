function solution(wallpaper) {
    var min_location = [wallpaper.length, wallpaper[0].length]
    var max_location = [0, 0]
    for (let i = 0; i < wallpaper.length; i++) {
        for (let j = 0; j < wallpaper[i].length; j++) {
            if (wallpaper[i][j] === '#') {
                min_location = [Math.min(min_location[0], i), Math.min(min_location[1], j)]
                max_location = [Math.max(max_location[0], i + 1), Math.max(max_location[1], j + 1)]
            }
        }
    }
    return min_location.concat(max_location);
}