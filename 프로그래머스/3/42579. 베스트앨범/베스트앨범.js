function solution(genres, plays) {
    var answer = [];
    
    const playCntInfo = {};
    
    const playInfoList = [];
    
    for (let i = 0; i < genres.length; i++) {
        const genre = genres[i];
        const play = plays[i];
        playCntInfo[genre] = playCntInfo[genre] ? playCntInfo[genre] + play : play;
    }
    
    const sortedPlayCnt = Object.entries(playCntInfo).sort((a, b) => b[1] - a[1]).map((entry) => entry[0]);
    
    const songInfo = genres.map((g, i) => ({genre : g, index : i, playCnt : plays[i]}));
    
    sortedPlayCnt.forEach((k) => {
        let twoSongs = songInfo.filter((info) => info.genre === k);
        answer.push(twoSongs.sort((a, b) => b.playCnt - a.playCnt).slice(0, 2).map((song) => song.index));
    })
    
    return answer.flat();
}