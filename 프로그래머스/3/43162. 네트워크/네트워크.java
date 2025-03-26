class Solution {
    
    // 방문 배열
    static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        visited = new boolean[n + 1];
        
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {                
                DFS(i, n, computers);
                answer++;
            }
        }
        
        return answer;
    }
    
    private static void DFS(int c, int n, int[][] computers) {
        
        visited[c] = true;
        
        for (int i = 1; i <= n; i++) {
            if (!visited[i] && computers[c - 1][i - 1] == 1) {
                DFS(i, n, computers);
            }
        }
    }
}