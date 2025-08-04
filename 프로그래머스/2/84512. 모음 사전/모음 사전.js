function solution(word) {    
    // 알파벳 모음
    const charset = ["A", "E", "I", "O", "U"]
    // 사전 배열
    const dict = []    
    // dfs를 통해 사전 배열 생성
    function dfs(word) {
        if (word.length > 5) return
        if (word.length > 0) {
            dict.push(word)
        }
        for (let i = 0; i < charset.length; i++) {
            dfs(word + charset[i])
        }        
    }
    // 딕셔너리 생성
    dfs('')
    
    return dict.indexOf(word) + 1;
}