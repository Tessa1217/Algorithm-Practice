import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class Main {

  // 좌우
  static int[] dx = {0, 1, 0, -1};

  // 상하
  static int[] dy = {1, 0, -1, 0};

  // 지도의 크기
  static int N;

  // 지도 배열
  static int[][] map;

  // 방문 배열
  static boolean[][] visited;

  // 단지 수
  static int cnt = 1;

  // 단지 리스트
  static List<Integer> list;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());

    map = new int[N][N];
    visited = new boolean[N][N];
    list = new ArrayList<>();

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      String[] data = st.nextToken().split("");
      for (int j = 0; j < N; j++) {
        map[i][j] = Integer.parseInt(data[j]);
      }
    }

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (map[i][j] == 1 && !visited[i][j]) {
          BFS(i, j);
        }
      }
    }

    // 단지의 수 출력
    System.out.println(list.size());
    // 오름차순 출력
    list.stream().sorted().forEach(System.out::println);

  }

  // 탐색
  private static void BFS(int x, int y) {

    Queue<int[]> q = new LinkedList<>(); 
    // 시작점 추가
    q.offer(new int[]{x, y});
    visited[x][y] = true;

    int houseCnt = 1;

    // 큐가 빌 때까지 반복
    while (!q.isEmpty()) {
      // 큐에서 현재 위치 확인
      int[] current = q.poll();

      // 현재 위치에서 상하 좌우 기준으로 집이 있는지 여부 확인
      for (int i = 0; i < 4; i++) {
        int nx = current[0] + dx[i];
        int ny = current[1] + dy[i];

        if (isRange(nx, ny)) {
          if (map[nx][ny] == 1 && !visited[nx][ny]) {
            q.offer(new int[]{nx, ny});
            visited[nx][ny] = true;
            map[nx][ny] = cnt;
            houseCnt++;
          }
        }
      }
      
    }

    list.add(houseCnt);
    cnt++;

  }

  // 지도 내 유효한 좌표인지 범위 확인
  private static boolean isRange(int x, int y) {
    return x >= 0 && y >= 0 && x < N && y < N;
  } 

}
