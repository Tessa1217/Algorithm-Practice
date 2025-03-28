import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    
    // 정점, 간선, 시작
    static int V, E, R;
    
    // 그래프
    static List<List<Integer>> graph = new ArrayList<>();
        
    // 방문 처리 배열
    static int[] visited;
    
    // 방문 인덱스
    static int visitIdx;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        
        // 방문 처리 배열 초기화
        visited = new int[V + 1];
        visitIdx = 1;
        
        // 그래프 초기화
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }
        
        // 그래프에 연결 정보 담기
        for (int i = 0; i < E; i++) {
            StringTokenizer ster = new StringTokenizer(br.readLine());    
            int s = Integer.parseInt(ster.nextToken());
            int e = Integer.parseInt(ster.nextToken());
            graph.get(s).add(e);
            graph.get(e).add(s);
        }
        
        // 연결 노드 오름차순으로 정렬
        for (int i = 1; i <= V; i++) {
            Collections.sort(graph.get(i));
        }
        
        // BFS 진행
        BFS(R);
        
        // 방문 순서에 대한 출력 진행
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            sb.append(visited[i])
              .append("\n");
        }
        
        System.out.println(sb);
        
    }
    
    private static void BFS(int node) {
        Queue<Integer> queue = new LinkedList<>();        
        queue.offer(node);
        visited[node] = visitIdx;
        
        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            List<Integer> nodes = graph.get(currentNode);
            for (int i = 0; i < nodes.size(); i++) {
                int newNode = nodes.get(i);
                if (visited[newNode] == 0) {
                    // 방문 처리
                    visitIdx++;
                    visited[newNode] = visitIdx;
                    // 큐에 삽입
                    queue.offer(newNode);                    
                }
            }
        }
    }
}