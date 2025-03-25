import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    
    // 정점의 개수, 간선의 개수, 정점의 번호
    static int N, M, V;
    
    // 그래프
    static int[][] graph;
    
    // 방문 배열
    static boolean[] visited;
    
    // 출력을 위한 StringBuilder
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        
        graph = new int[N + 1][N + 1];
        visited = new boolean[N + 1];
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = graph[b][a] = 1;
            
        }
        
        dfs(V);        
        
        visited = new boolean[N + 1];
        sb.append("\n");
        
        bfs(V);
        
        System.out.println(sb);
        
    }
    
    private static void bfs(int x) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(x);
        visited[x] = true;
        
        while (!q.isEmpty()) {
            int current = q.poll();
            sb.append(current + " ");
            for (int i = 1; i <= N; i++) {
                if (graph[current][i] == 1 && !visited[i]) {
                    q.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
    
    private static void dfs(int x) {
        
       visited[x] = true;
       sb.append(x + " ");
       
       for (int i = 1; i <= N; i++) {
           if (graph[x][i] == 1 && !visited[i]) {               
               dfs(i);
           }
       }
    }
}