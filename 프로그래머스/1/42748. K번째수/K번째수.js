function solution(array, commands) {
    
    const answer = [];
    
    for (let i = 0; i < commands.length; i++) {
        const command = commands[i];
        const commandArr = [...array].slice(command[0] - 1, command[1]);     
        // sort는 문자열로 강제 형변환하므로 숫자 정렬 시 sort에 comapreFunction 전달 필요
        commandArr.sort((a, b) => a - b);
        answer.push(commandArr[command[2] - 1]);        
    }

    return answer;
}