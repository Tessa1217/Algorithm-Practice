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

    int T = Integer.parseInt(st.nextToken());

    for (int i = 0; i < T; i++) {
      st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      int[] testcase = new int[N];
      boolean[] visited = new boolean[N];
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        testcase[j] = Integer.parseInt(st.nextToken());
      }
      search(testcase, visited);  
    }
  }

  private static void search(int[] testcase, boolean[] visited) {

    int cycleCnt = 0;
    for (int i = 1; i <= testcase.length; i++) {
      if (!visited[i - 1]) {
        visited[i - 1] = true;
        cycle(i, testcase, visited);
        cycleCnt++;
      }
    }

    System.out.println(cycleCnt);

  }

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
