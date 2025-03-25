import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    
    // 상자 가로칸의 수 M, 세로 칸의 수 N;
    static int M, N;
    
    // 토마토 배열
    static int[][] tomatoes;
    
    // 상하좌우
    static int[] dx = {1, -1, 0, 0};
    
    static int[] dy = {0, 0, 1, -1};
    
    // 큐
    static Queue<int[]> queue;
     
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 상자 정보
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        
        // 토마토와 방문 배열 초기화
        tomatoes = new int[N][M];
        queue = new LinkedList<>();
                
        // 토마토 배열 세팅
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                tomatoes[i][j] = Integer.parseInt(st.nextToken());
                if (tomatoes[i][j] == 1) {                                  
                    queue.offer(new int[]{i, j});
                }
            }
        }
        
        BFS();
        
        System.out.println(checkTomatoStatus() - 1);
        
    }
    
    private static void BFS() {
        while (!queue.isEmpty()) {
            int[] currentTomato = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = currentTomato[0] + dx[i];
                int ny = currentTomato[1] + dy[i];
                if (isBoxRange(nx, ny)) {
                    // 방문하지 않았고, 토마토가 익지 않은 경우
                    if (tomatoes[nx][ny] == 0) {                        
                        tomatoes[nx][ny] = tomatoes[currentTomato[0]][currentTomato[1]] + 1;                  
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }
        
    }
    
    // 토마토 상태 체크
    private static int checkTomatoStatus() {
        int day = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tomatoes[i][j] == 0) {
                    return 0;
                }
                
                day = Math.max(day, tomatoes[i][j]);
            }
        }
        return day;
    }
    
    // 상자 범위 내의 유효한 좌표인지 확인
    private static boolean isBoxRange(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M;
    }
}