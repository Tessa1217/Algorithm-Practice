import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {

  // 컴퓨터의 수, 컴퓨터의 쌍의 수
  static int N, CN;

  // 컴퓨터 쌍 배열
  static int[][] computer;

  // 방문 여부 배열
  static boolean[] visited;

  // 바이러스 감염 컴퓨터 수
  static int cnt = 0;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    
    CN = Integer.parseInt(br.readLine());

    // 배열 초기화
    computer = new int[N + 1][N + 1];

    visited = new boolean[N + 1];

    // 컴퓨터 쌍 입력
    for (int i = 0; i < CN; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      computer[a][b] = computer[b][a] = 1;
    }

    dfs(1);

    System.out.println(cnt - 1);
   
  }

  private static void dfs(int c) {

    visited[c] = true;
    cnt++;

    for (int i = 0; i <= N; i++) {
      if (computer[c][i] == 1 && !visited[i]) {
        dfs(i);
      }
    }

    
  }

  
}
