import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.List;
import java.util.Collections;
import java.util.ArrayList;

public class Main {
    
    // 정점 집합, 간선 집합, 시작 정점
    static int V, E, R;
    
    // 방문 배열
    static int[] visited;
    
    // 방문한 노드 리스트
    static List<List<Integer>> graph = new ArrayList<>();
    
    // 방문 순서 인덱스
    static int visitIdx;
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 정점
        V = Integer.parseInt(st.nextToken());
        // 간선
        E = Integer.parseInt(st.nextToken());
        // 시작
        R = Integer.parseInt(st.nextToken());
        
        visited = new int[V + 1];
        
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }
        
        // 연결
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph.get(s).add(e);
            graph.get(e).add(s);
        }
        
        // 정점 번호를 오름차순 방문하므로 정렬
        for (int i = 1; i <= V; i++) {
            Collections.sort(graph.get(i));
        }
        
        
        visitIdx = 1;
        // DFS 시작
        DFS(R);
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 1; i <= V; i++) {
            sb.append(visited[i]).append("\n");
        }
        
        System.out.println(sb);
        
    }
    
    // DFS
    private static void DFS(int node) {
        
        visited[node] = visitIdx;        
        
        List<Integer> connectNodes = graph.get(node);
        
        for (int i = 0; i < connectNodes.size(); i++) {
            int next = connectNodes.get(i);
            if (visited[next] == 0) {
                visitIdx++;
                DFS(next);
            }
        }
        
    }
}