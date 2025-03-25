import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    
    // 세로 M, 가로 N;
    static int M, N;
    
    // 모눈종이
    static int[][] paper;    
    
    // 분리된 영역 표기 배열
    static int[][] separated;
    
    // 분리된 영역 수
    static int separatedCnt = 0;
    
    // 분리된 영역 너비 배열
    static List<Integer> separatedAreaCntList;
    
    // 상하좌우 탐색 배열
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        paper = new int[M][N];
        separated = new int[M][N];
        
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());    
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            
            for (int j = y1; j < y2; j++) {
                for (int k = x1; k < x2; k++) {
                    // 직사각형이 그려진 부분은 1로 세팅
                    paper[j][k] = 1;
                }
            }
        }
        
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (separated[i][j] == 0 && paper[i][j] == 0) {
                    separatedCnt++;
                    bfs(i, j);
                }
            }
        }
        
        System.out.println(separatedCnt);
        
        int[] areaCntArr = new int[separatedCnt];
        
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (separated[i][j] > 0) {
                    areaCntArr[separated[i][j] - 1]++;
                }
            }   
        } 
        
        Arrays.sort(areaCntArr);
        
        for (int i = 0; i < areaCntArr.length; i++) {
            System.out.printf(String.valueOf(areaCntArr[i]));
            if (i < areaCntArr.length - 1) {
                System.out.printf(" ");
            }
        }
    }
    
    private static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        separated[x][y] = separatedCnt;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];
                
                if (nx >= 0 && nx < M && ny >= 0 && ny < N) {
                    if (separated[nx][ny] == 0 && paper[nx][ny] == 0) {
                        separated[nx][ny] = separatedCnt;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }
        
    }
}