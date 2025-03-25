import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {

  // 수빈이의 위치 N, 동생의 위치 M
  static int N, K;

  // 찾은 시간
  static int time = 0;

  // 방문 배열
  static boolean[] visited;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    visited = new boolean[100001];

    // 위치 찾기 시작
    find(N, 0);

    System.out.println(time);

  }

  private static void find(int position, int depth) {

    // 시작값
    Queue<int[]> q = new LinkedList<>();
    q.offer(new int[]{position, depth});
    visited[position] = true;

    while (!q.isEmpty()) {

      int[] currentPosition = q.poll();

      if (currentPosition[0] == K) {
        time = currentPosition[1];
        break;
      }

      // 뒤로 걸어가기
      int walkBack = currentPosition[0] - 1;
      if (isRange(walkBack) && !visited[walkBack]) {
        visited[walkBack] = true;
        q.offer(new int[]{walkBack, currentPosition[1] + 1});
      }
      
      // 앞으로 걸어가기
      int walkFront = currentPosition[0] + 1;
      if (isRange(walkFront) && !visited[walkFront]) {
        visited[walkFront] = true;
        q.offer(new int[]{walkFront, currentPosition[1] + 1});
      }      

      // 순간이동
      int teleport = currentPosition[0] * 2;
      if (isRange(teleport) && !visited[teleport]) {
        visited[teleport] = true;
        q.offer(new int[]{teleport, currentPosition[1] + 1});
      }            

    }

  }

  private static boolean isRange(int position) {
    return position >= 0 && position <= 100000;
  }


}
