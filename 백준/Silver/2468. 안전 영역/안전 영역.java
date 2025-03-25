import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    
    // 행열 수
    static int N;
    
    // 지역 배열
    static int[][] area;
    
    // 장마 시 지역 배열
    static int[][] rainArea;
    
    // 최대 안전 영역 개수
    static int maxAreaCnt = 0;
    
    // 상하좌우 확인 배열
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        
        area = new int[N][N];        
        
        int maxHeight = 0;
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                area[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, area[i][j]);
            }
        }
        
        for (int h = 0; h < maxHeight; h++) {
            int areaCnt = 0;
            rainArea = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    // 방문 지역이 아니고 침수된 지역이 아닌 경우
                    if (rainArea[i][j] == 0 && area[i][j] > h) {
                        areaCnt++;
                        // 주변 영역 탐색
                        bfs(i, j, h, areaCnt);
                    }
                }
            }   
            maxAreaCnt = Math.max(maxAreaCnt, areaCnt);
        }        
        
        System.out.println(maxAreaCnt);
        
        
    }
    
    private static void bfs(int x, int y, int h, int areaCnt) {
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        rainArea[x][y] = areaCnt;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            // 현재 지역의 상하좌우 침수 여부 확인
            for (int i = 0; i < 4; i++) {
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    if (rainArea[nx][ny] == 0 && area[nx][ny] > h) {
                        rainArea[nx][ny] = areaCnt;
                        queue.offer(new int[]{nx, ny});
                    }
                }                
            }
        }                
        
    }
    
}