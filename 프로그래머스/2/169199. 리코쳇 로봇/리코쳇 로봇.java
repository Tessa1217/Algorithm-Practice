/** 말의 이동은 현재 위치에서 상, 하, 좌, 우 중 한 방향으로 게임판 위의 장애물이나 게임판 가장자리까지 부딪힐 때까지 미끄러져 움직인다
# 생각: 
#   목표 지점의 상하좌우 중 1개 이상이 가장자리에 맞닿아 있지 않거나 장애물이 없다면 말은 목표 지점을 지나치기만 하고 도달할 수는 없다
#   목표지점의 상하좌우가 모두 장애물로 막혀있거나 가장자리에 맞닿아 있을 경우 로봇은 영원히 목표 지점에 도달할 수 없다
#   => 위의 조건으로 목표 위치에 도달할 수 없는 경우의 수를 먼저 거른다
#   최단거리를 찾는 것이 목표이기 때문에 BFS 탐색을 진행한다 (이미 사전에 방문한 지점, 장애물이 있는 지점, 가장자리 너머의 지점을 거르고 탐색)
*/
import java.util.Queue;
import java.util.LinkedList;

class Solution {
    
    private int n, m;
    
    private int[] dn = {1, -1, 0, 0};
    
    private int[] dm = {0, 0, 1, -1};
    
    public int solution(String[] board) {
        
        // 시작 좌표
        int x = 0;
        int y = 0;
        
        n = board.length;
        m = board[0].length();
        
        // 최초 시작점 찾기
        for (int i = 0; i < n; i++) {
            String b = board[i];
            for (int j = 0; j < m; j++) {
                if (b.charAt(j) == 'R') {
                    x = i;
                    y = j;
                }
            }
        }
        
        return bfs(board, x, y);        
    }
    
    private int bfs(String[] board, int x, int y) {
        
        Queue<RobotRoute> queue = new LinkedList<>();
        queue.offer(new RobotRoute(x, y, 0));
        boolean[][] visited = new boolean[n][m];
        
        
        while (!queue.isEmpty()) {
            RobotRoute currentRoute = queue.poll();
            int rx = currentRoute.getX();
            int ry = currentRoute.getY();
            visited[rx][ry] = true;    
            
            for (int i = 0; i < 4; i++) {
                int nx = rx + dn[i];
                int ny = ry + dm[i];
                
                while (true) {
                    if (!isRange(nx, ny) || board[nx].charAt(ny) == 'D') {
                        nx -= dn[i];
                        ny -= dm[i];
                        break;
                    }   
                    nx += dn[i];
                    ny += dm[i];
                }                
                
                if (board[nx].charAt(ny) == 'G') {
                    return currentRoute.getMove() + 1;
                }
                
                if (!visited[nx][ny]) {
                    queue.offer(new RobotRoute(nx, ny, currentRoute.getMove() + 1));    
                }                
                
            }
        }
        
        return -1;
    }
    
    private boolean isRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }
    
    class RobotRoute {
        private int x;
        private int y;
        private int move;
        
        public RobotRoute(int x, int y, int move) {
            this.x = x;
            this.y = y;
            this.move = move;
        }
        
        public int getX() {
            return this.x;
        }
        
        public int getY() {
            return this.y;
        }
        
        public int getMove() {
            return this.move;
        }
    }
}