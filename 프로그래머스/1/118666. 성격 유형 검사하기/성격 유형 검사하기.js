function solution(survey, choices) {
    
    const data = ['R', 'T', 'C', 'F', 'J', 'M', 'A', 'N']
    const score_map = Array.from({length : data.length}, () => 0)
    
    for (let i = 0; i < survey.length; i++) {
        if (choices[i] === 4) {
            continue
        }
        const chosen_data = choices[i] < 4 ? survey[i][0] : survey[i][1]                
        const score_map_idx = data.indexOf(chosen_data)
        const chosen_score = Math.abs(choices[i] - 4)
        
        score_map[score_map_idx] += chosen_score
        
    }    
    
    const personality_type = []
    
    for (let i = 0; i < score_map.length; i += 2) {
        if (score_map[i] >= score_map[i + 1]) {
            personality_type.push(data[i])
        } else {
            personality_type.push(data[i + 1])
        }
    }
    return personality_type.join("");
}