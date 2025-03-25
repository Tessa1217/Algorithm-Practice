import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    
    // 지도의 너비, 높이
    static int w, h;
    
    // 지도
    static int[][] map;
    
    // 상하좌우대각선 땅 확인
    static int[] dx = {0, 1, 0, -1, 1, 1, -1, -1};
    
    static int[] dy = {1, 0, -1, 0, 1, -1, 1, -1};
    
    // 섬의 개수
    static int cnt;
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            // 가로
            w = Integer.parseInt(st.nextToken());
            
            // 세로
            h = Integer.parseInt(st.nextToken());
            
            // 마지막 줄에는 0이 두 개 주어진다.
            if (w == 0 && h == 0) {
                br.close();
                break;
            }
            
            // 지도 초기화 및 데이터 세팅
            map = new int[h][w];
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            cnt = 0;
            
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (map[i][j] == 1) {
                        BFS(i, j);
                        cnt++;
                    }
                }
            }
            
            System.out.println(cnt);
            
        }
                    
        
    }
    
    // BFS
    private static void BFS(int x, int y) {
        
        // 검사 시작점 세팅
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        map[x][y] = 0;
        
        // 큐가 빌 때까지
        while (!queue.isEmpty()) {
            int[] currentLocation = queue.poll();
            // 현재 지도 기준으로 가로, 세로, 대각선 연결된 땅 확인하기
            for (int i = 0; i < 8; i++) {
                int nx = currentLocation[0] + dx[i];
                int ny = currentLocation[1] + dy[i];
                if (isRange(nx, ny)) {
                    if (map[nx][ny] == 1) {
                        map[nx][ny] = 0;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }
        
    }
    
    // 유효현 지도 범위 내인지 검증
    private static boolean isRange(int x, int y) {
        return x >= 0 && y >= 0 && x < h && y < w;
    }
}