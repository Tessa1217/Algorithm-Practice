function solution(dirs) {    
    
    const dir_coord = {
        "U" : [1, 0],
        "D" : [-1, 0],
        "R" : [0, 1],
        "L" : [0, -1],
    }
    
    let rx = 0;
    let ry = 0;
    
    const route_set = new Set();    
    
    for (let d of dirs) {
        let coord = dir_coord[d];
        let nx = rx + coord[0]
        let ny = ry + coord[1]
        
        if (nx < -5 || nx > 5 || ny < -5 || ny > 5) {
            continue;
        }
                
        route_set.add("" + rx + ry + nx + ny);
        route_set.add("" + nx + ny + rx + ry);
                
        
        rx = nx
        ry = ny
        
    }
    
    return route_set.size / 2;
}

function generate_route_string(rx, ry, nx, ny) {
    return `${Math.min(rx, nx)}${Math.min(ry, ny)}${Math.max(rx, nx)}${Math.max(ry, ny)}`
}