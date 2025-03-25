import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

public class Main {

  // 트리
  static List<List<Integer>> tree;

  // 부모 노드 배열
  static int[] parent;

  static boolean[] visited;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    tree = new ArrayList<>();
    parent = new int[N + 1];
    visited = new boolean[N + 1];

    // 트리 배열 초기화
    for (int i = 0; i <= N; i++) {
      tree.add(new ArrayList<>());
    }

    // 트리 배열 세팅
    for (int i = 0; i < N - 1; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int node1 = Integer.parseInt(st.nextToken());
      int node2 = Integer.parseInt(st.nextToken());
      insertNode(node1, node2);
      insertNode(node2, node1);
    }

    BFS(1);

    for (int i = 2; i <= N; i++) {
      System.out.println(parent[i]);
    }

  }

  private static void BFS(int node) {

    Queue<Integer> queue = new LinkedList<>();
    queue.add(node);
    visited[node] = true;

    while (!queue.isEmpty()) {
      int currentNode = queue.poll();
      for (int n : tree.get(currentNode)) {
        if (!visited[n]) {
          visited[n] = true;
          parent[n] = currentNode;
          queue.add(n);
        }
      }
    }
  }

  private static void insertNode(int node1, int node2) {

    if (tree.get(node1) == null) {
      tree.set(node1, new ArrayList<>());
    }        
    tree.get(node1).add(node2);

  }

}
