import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    
    // 세로 크기, 가로 크기
    static int n, m;
    
    // 그림 배열
    static int[][] picture;
    
    // 상하좌우 확인 배열
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    
    // 그림의 수
    static int pictureCnt = 1;
    
    // 가장 큰 그림의 영역
    static int maxPictureArea = 0;
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        picture = new int[n][m];
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                picture[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (picture[i][j] == 1) {
                    pictureCnt++;
                    BFS(i, j);
                }
            }
        }
        
        System.out.println(pictureCnt - 1);
        System.out.println(maxPictureArea);
        
    }
    
    private static void BFS(int x, int y) {
                        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        picture[x][y] = pictureCnt;
        int cnt = 1;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (picture[nx][ny] == 1) {
                        picture[nx][ny] = pictureCnt;
                        cnt++;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }
        
        maxPictureArea = Math.max(cnt, maxPictureArea);
        
    }
}