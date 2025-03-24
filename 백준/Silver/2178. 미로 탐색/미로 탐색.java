import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
        
    static int[] dx = {0, 1, 0, -1};
    
    static int[] dy = {1, 0, -1, 0};
    
    static int[][] maze;
    
    static int N, M;
    
    static boolean[][] visited;
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        // 1. 배열, 방문 배열 초기화
        maze = new int[N][M];        
        visited = new boolean[N][M];
        
        // 2. 미로 배열에 데이터 저장하기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for (int j = 0; j < M; j++) {
                maze[i][j] = Integer.parseInt(str.substring(j, j + 1));
            }
        }
        
        // 3. BFS 실행
        BFS(0, 0);
        
        System.out.println(maze[N - 1][M - 1]);
        
    }
    
    private static void BFS(int n, int m) {
        Queue<int[]> q = new LinkedList<>();
        // 1. 시작 노드 삽입
        q.offer(new int[]{n, m});
        
        // 2. 큐가 빌 때까지
        while (!q.isEmpty()) {
            // 3. 노드 꺼내기
            int[] node = q.poll();
            // 4. 방문 배열에 시작 노드 방문 여부 체크
            visited[n][m] = true;
            for (int i = 0; i < 4; i++) {
                int y = node[0] + dy[i];
                int x = node[1] + dx[i];
                // 5. 유효성 검증 진행
                if (isValid(y, x)) {
                    // 6. 이동 가능한 좌표이며 방문하지 않았을 경우
                    if (maze[y][x] == 1 && !visited[y][x]) {
                        maze[y][x] = maze[node[0]][node[1]] + 1;
                        q.add(new int[]{y, x});
                        visited[y][x] = true;
                    }
                }
            }
        }        
    }
    
    // 유효한 좌표값인지 체크
    private static boolean isValid(int n, int m) {
        return n >= 0 && m >= 0 && n < N && m < M;
    }
}