class Solution {
    
    // 던전 길이
    static int maxRound;
    
    // 최대 던전 돈 횟수
    static int maxDungeon = 0;
    
    // 던전 배열
    static int[][] dungeons;
    
    // 던전 방문 확인용 배열
    static boolean[] visited;
    
    public int solution(int k, int[][] dungeonsInfo) {
        
        maxRound = dungeonsInfo.length;
        dungeons = dungeonsInfo;
        visited = new boolean[maxRound];
        
        runDungeon(0, k, 0);
        
        return maxDungeon;
    }
    
    private void runDungeon(int round, int hp, int roundCnt) {
        if (round == maxRound) {
            maxDungeon = Math.max(roundCnt, maxDungeon);
            return;
        }
        for (int i = 0; i < dungeons.length; i++) {
            if (visited[i]) {
                continue;
            }
            if (hp >= dungeons[i][0]) {                
                int newHp = hp - dungeons[i][1];
                int newRoundCnt = roundCnt + 1;
                visited[i] = true;
                runDungeon(round + 1, newHp, newRoundCnt);
                visited[i] = false;                
            } else {
               maxDungeon = Math.max(roundCnt, maxDungeon); 
            }           
        }
    }    
    
}