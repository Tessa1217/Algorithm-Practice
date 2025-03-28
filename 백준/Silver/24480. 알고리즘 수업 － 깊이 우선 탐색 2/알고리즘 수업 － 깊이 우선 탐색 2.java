import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    // 정점, 간선, 시작
    static int V, E, R;
    
    // 그래프
    static List<List<Integer>> graph = new ArrayList<>();
    
    // 방문 순서 배열
    static int[] visited;
    
    // 방문 인덱스
    static int idx;
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
                
        V = Integer.parseInt(st.nextToken());        
        E = Integer.parseInt(st.nextToken());        
        R = Integer.parseInt(st.nextToken());
        
        // 방문 순서 배열, 방문 인덱스 초기화
        idx = 1;
        visited = new int[V + 1];
        
        // 그래프 초기화
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }
        
        // 그래프 연결
        for (int i = 0; i < E; i++) {
            StringTokenizer ster = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(ster.nextToken());
            int e = Integer.parseInt(ster.nextToken());
            // 그래프 연결 진행
            graph.get(s).add(e);
            graph.get(e).add(s);
        }
        
        // 정점 번호 내림차순 방문을 위한 내림차순 정렬
        for (int i = 1; i <= V; i++) {
            Collections.sort(graph.get(i), Collections.reverseOrder());
        }
        
        // DFS 실행
        DFS(R);
        
        // 방문 배열에 대한 순서 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            sb.append(visited[i])
              .append("\n");
        }
        
        System.out.println(sb);
        
    }
    
    private static void DFS(int node) {
        
        // 정점 번호에 대한 방문 처리
        visited[node] = idx;
        
        for (int i = 0; i < graph.get(node).size(); i++) {
            int newNode = graph.get(node).get(i);
            // 방문하지 않았다면
            if (visited[newNode] == 0) {
                idx++;
                DFS(newNode);
            }
        }
    }
}