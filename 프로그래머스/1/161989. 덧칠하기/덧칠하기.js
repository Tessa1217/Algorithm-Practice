function solution(n, m, section) {
    var painted_section = []
    while (section.length) {
        current_wall = section.pop()                
        if (painted_section.length === 0 
            || painted_section[painted_section.length - 1] - m >= current_wall) {
            painted_section.push(current_wall)
        }        
    }
    return painted_section.length;
}