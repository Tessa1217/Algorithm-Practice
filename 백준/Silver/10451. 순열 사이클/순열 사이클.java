import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    // 테스트 케이스의 개수
    int T = Integer.parseInt(st.nextToken());

    // 테스트 케이스의 개수만큼 테스트 배열 채우기
    for (int i = 0; i < T; i++) {
      st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      // 테스트 케이스 배열
      int[] testcase = new int[N];
      // 방문 배열
      boolean[] visited = new boolean[N];
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        testcase[j] = Integer.parseInt(st.nextToken());
      }
      // 사이클 탐색 시작
      search(testcase, visited);  
    }
  }

  // 사이클 탐색
  private static void search(int[] testcase, boolean[] visited) {

    // 순열 사이클 개수
    int cycleCnt = 0;
    for (int i = 1; i <= testcase.length; i++) {
      // 아직 방문하지 않았을 경우
      if (!visited[i - 1]) {
        visited[i - 1] = true;
        // 해당 노드에 대한 사이클 탐색 시작
        cycle(i, testcase, visited);
        cycleCnt++;
      }
    }

    System.out.println(cycleCnt);

  }

  // 노드에 대한 사이클 탐색
  private static void cycle(int start, int[] testcase, boolean[] visited) {
    
    Queue<Integer> q = new LinkedList<>();
    q.offer(start);

    while (!q.isEmpty()) {
      int current = q.poll(); // 1
      int next = testcase[current - 1];  // 3
      if (!visited[next - 1]) {
        q.offer(next);
        visited[next - 1] = true;
      }
    }

  }
  
}
