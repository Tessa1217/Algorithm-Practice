import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {

  // 상하좌우 이동
  static int[] dx = {0, 1, 0, -1};

  static int[] dy = {1, 0, -1, 0};

  // 테스트 케이스, 가로 길이, 세로 길이
  static int T, M, N;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 테스트 케이스별 필요한 변수 초기화
    T = Integer.parseInt(br.readLine());

    // 테스트 케이스 입력 (배추 위치)
    for (int i = 0; i < T; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      // 가로
      M = Integer.parseInt(st.nextToken());
      // 세로
      N = Integer.parseInt(st.nextToken());
      // 심겨진 배추의 수
      int K = Integer.parseInt(st.nextToken());

      int[][] cabbage = new int[N][M];
      
      for (int j = 0; j < K; j++) {
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        cabbage[b][a] = 1;
      }

      int wormCnt = 0;

      for (int x = 0; x < cabbage.length; x++) {
        for (int y = 0; y < cabbage[x].length; y++) {
          if (cabbage[x][y] == 1) {
            bfs(cabbage, x, y);
            wormCnt++;
          }
        }
      }

      System.out.println(wormCnt);
      
    }    
  }

  // BFS 탐색
  private static void bfs(int[][] cabbage, int x, int y) {

    Queue<int[]> q = new LinkedList<>();
    q.offer(new int[]{x, y});
    cabbage[x][y] = 0;

    while (!q.isEmpty()) {
      int[] current = q.poll();
      for (int i = 0; i < 4; i++) {
        int nx = current[0] + dx[i];
        int ny = current[1] + dy[i];

        if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
          if (cabbage[nx][ny] == 1) {
            cabbage[nx][ny] = 0;
            q.offer(new int[]{nx, ny});
          }
        }
      }
    }
  }  

}
