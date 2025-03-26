class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        
        // 서버 증설 배열
        int[] server = new int[24];
        
        for (int i = 0; i < players.length; i++) {
            
            // 현재 증설된 서버 수
            int serverCnt = server[i];
            // 필요한 서버의 수
            int reqServerCnt = players[i] / m;
            
            // 증설된 서버보다 필요한 서버가 많을 경우
            if (serverCnt < reqServerCnt) {
                // 증설 필요한 서버의 수
                int newServer = reqServerCnt - serverCnt;
                answer += newServer;
                // 최대 시간 (24시간 넘을 경우)
                int maxTime = Math.min(players.length, i + k);
                // 서버 증설 배열에 신규 증설된 서버의 수 유효 시간 범위 내에서 더하기
                for (int j = i; j < maxTime; j++) {
                    server[j] += newServer;
                }
            }
            
        }
        return answer;
    }
}