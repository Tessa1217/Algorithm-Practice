import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    
    // 정점, 간선, 시작 정점
    static int V, E, K;
    
    // 방향 그래프
    static List<List<Node>> graph = new ArrayList<>();
    
    // 가중치 저장 배열
    static int[] distance;
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 정점, 간선, 시작 정점 초기화
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());        
        K = Integer.parseInt(br.readLine());
        
        // 가중치 저장 배열 초기화
        distance = new int[V + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[K] = 0;
        
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < E; i++) {
            StringTokenizer ster = new StringTokenizer(br.readLine());
            // 출발 정점
            int u = Integer.parseInt(ster.nextToken());
            // 도착 정점
            int v = Integer.parseInt(ster.nextToken());
            // 가중치
            int w = Integer.parseInt(ster.nextToken());
            // 방향 그래프
            graph.get(u).add(new Node(v, w));
        }
        
        dijkstra();
        
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                sb.append("INF");                   
            } else {
                sb.append(distance[i]);
            }            
            sb.append("\n");
        }
        
        System.out.println(sb);
        
    }
    
    private static void dijkstra() {
        // 우선순위 큐
        PriorityQueue<Node> queue = new PriorityQueue<Node>((o1, o2) -> o1.getW() - o2.getW());
        queue.offer(new Node(K, distance[K]));
        
        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            // 만약 현재 저장된 가중치 배열의 값보다 정점의 가중치 값이 크다면 고려하지 않고 스킵
            if (distance[currentNode.getV()] < currentNode.getW()) {
                continue;
            }
            List<Node> nodeList = graph.get(currentNode.getV());
            for (Node node : nodeList) {
                if (distance[node.getV()] > node.getW() + currentNode.getW()) {
                    distance[node.getV()] = node.getW() + currentNode.getW();
                    queue.offer(new Node(node.getV(), distance[node.getV()]));
                }
            }
        }
    }
}

class Node {
    
    // 정점 번호
    private int v;
    
    // 가중치
    private int w;
    
    public Node(int v, int w) {
        this.v = v;
        this.w = w;
    }
    
    public int getV() {
        return this.v;
    }
    
    public int getW() {
        return this.w;
    }
    
}