import java.util.Queue;
import java.util.LinkedList;

class Solution {
    
    // 게임 맵 크기
    static int n, m;
    
    // 맵 배열
    static int[][] maps;
    
    // 방문 배열
    static int[][] visited;
    
    // 로봇의 움직임
    static int[][] move = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    public int solution(int[][] mapData) {
        
        n = mapData.length;
        m = mapData[0].length;
        maps = mapData;
        visited = new int[n][m];
                
        // 최초 지점에서 BFS 시작
        BFS(0, 0, 1);
        
        // 도착지 정보
        int destination = visited[n - 1][m - 1];
        
        return destination == 0 ? -1 : destination;
        
    }
    
    // BFS
    private static void BFS(int x, int y, int depth) {
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = depth;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            for (int i = 0; i < move.length; i++) {
                int nx = current[0] + move[i][0];
                int ny = current[1] + move[i][1];
                if (isMapRange(nx, ny)) {
                    if (visited[nx][ny] == 0 && maps[nx][ny] == 1) {
                        visited[nx][ny] = visited[current[0]][current[1]] + 1;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }
    }
    
    // 맵 내의 유효한 좌표인지 확인
    private static boolean isMapRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }
}