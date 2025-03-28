import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    
    // 3차원 행렬 정보
    static int H, M, N;
    
    // 토마토 저장고
    static int[][][] tomatoes;
    
    // 큐
    static Queue<Tomato> queue = new LinkedList<>();
    
    // 토마토 익는 방향 배열
    static int[] dm = {1, -1, 0, 0, 0, 0};
    static int[] dn = {0, 0, 1, -1, 0, 0};
    static int[] dh = {0, 0, 0, 0, 1, -1};
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        
        // 토마토 상자 초기화
        tomatoes = new int[H][N][M];
        
        // 토마토 현재 정보 담기
        for (int i = 0; i < H; i++) {            
            for (int j = 0; j < N; j++) {
                StringTokenizer ster = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    tomatoes[i][j][k] = Integer.parseInt(ster.nextToken());
                    // 익은 토마토의 경우
                    if (tomatoes[i][j][k] == 1) {
                        queue.offer(new Tomato(i, j, k));
                    }
                }
            }
        }
        
        BFS();
        
        int date = 0;
        
        // 토마토의 상태 체크
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k  = 0; k < M; k++) {
                    // 덜 익은 게 있다면
                    if (tomatoes[i][j][k] == 0) {
                        System.out.println(-1);
                        return;
                    }
                    date = Math.max(date, tomatoes[i][j][k]);
                }
            }
        }
        
        if (date > 0) {
            System.out.println(date - 1);
        }
        
    }
    
    private static void BFS() {
        while (!queue.isEmpty()) {
            Tomato current = queue.poll();
            for (int i = 0; i < 6; i++) {
                
                int nh = current.getH() + dh[i];
                int nn = current.getN() + dn[i];
                int nm = current.getM() + dm[i];
                
                // 상자 범위 내라면
                if (isRange(nh, nn, nm)) {
                    // 아직 익지 않았다면
                    if (tomatoes[nh][nn][nm] == 0) {
                        queue.offer(new Tomato(nh, nn, nm));
                        tomatoes[nh][nn][nm] = tomatoes[current.getH()][current.getN()][current.getM()] + 1;
                    }
                }
            }
            
        }
    }
    
    // 유요한 상자 범위인지 확인
    private static boolean isRange(int h, int n, int m) {
        return h >= 0 && h < H && n >= 0 && n < N && m >= 0 && m < M;
    }
}

// 토마토 위치 저장을 위한 클래스 생성
class Tomato {
    
    // 상자 높이 위치
    private int h;
    
    // 상자 세로 위치
    private int n;
    
    // 상자 가로 위치
    private int m;
    
    public Tomato(int h, int n, int m) {
        this.h = h;
        this.n = n;
        this.m = m;
    }
    
    public int getH() {
        return this.h;
    }
    
    public int getN() {
        return this.n;
    }
    
    public int getM() {
        return this.m;
    }
    
}