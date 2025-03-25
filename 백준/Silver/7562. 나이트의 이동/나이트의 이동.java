import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    
    // 테스트 케이스
    static int T;
    
    // 체크판 한 변의 길이
    static int I;
    
    // 체스판
    static int[][] chess;
    
    // 나이트가 이동할 수 있는 칸
    static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};
    
    // 나이트가 이동할 칸
    static int[] destination = new int[2];
        
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 테스트 케이스 개수 받기
        T = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < T; i++) {
            
            // 체스판 초기화
            I = Integer.parseInt(br.readLine());
            chess = new int[I][I];
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            // 현재 체스판의 위치
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            st = new StringTokenizer(br.readLine());
            
            // 체스판이 도달해야 하는 위치
            destination[0] = Integer.parseInt(st.nextToken());
            destination[1] = Integer.parseInt(st.nextToken());            
            
            // 나이트 움직이기
            moveKnight(x, y, 0);
            
        }
    }
    
    // 나이트 움직이기
    private static void moveKnight(int x, int y, int moveCnt) {
        
        // 최초 나이트의 위치 세팅
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y, moveCnt});
        
        while (!queue.isEmpty()) {
            int[] c = queue.poll();
            // 목적지에 도달했을 경우
            if (c[0] == destination[0] && c[1] == destination[1]) {
                System.out.println(c[2]);
                break;
            }
            // 나이트가 움직일 수 있는 경로에 대한 확인 처리
            for (int i = 0; i < 8; i++) {
                int nx = c[0] + dx[i];
                int ny = c[1] + dy[i];                
                // 유효한 범위 내라면
                if (isRange(nx, ny)) {
                    if (chess[nx][ny] == 0) { // 아직 이동하지 않은 경로라면
                        int nm = c[2] + 1; // 이동 횟수 + 1
                        chess[nx][ny] = nm;
                        queue.offer(new int[]{nx, ny, nm});
                    }
                }
            }
        }
        
    }
    
    // 체스판 내부 유효한 범위인지 검증
    private static boolean isRange(int x, int y) {
        return x >= 0 && y >= 0 && x < I && y < I;
    }
}