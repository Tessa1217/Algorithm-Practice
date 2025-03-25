import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {

  // 정점의 개수 N, 간선의 개수 M
  static int N, M;

  // 그래프
  static int[][] graph;

  // 방문 배열
  static boolean[] visited;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    graph = new int[N + 1][N + 1];
    visited = new boolean[N + 1];

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      graph[a][b] = graph[b][a] = 1;
    }

    int cnt = 0;

    for (int i = 1; i <= N; i++) {
     if (!visited[i]) {
        DFS(i);
        cnt++;         
     }
    }
      
    System.out.println(cnt);

  }

  private static void DFS(int x) {
      
    if (visited[x]) {
        return;
    }

    visited[x] = true;

    for (int i = 1; i <= N; i++) {
      if (graph[x][i] == 1) {
        DFS(i);
      }
    }
  }


}
