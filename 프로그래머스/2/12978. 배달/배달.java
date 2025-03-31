import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Arrays;
import java.util.Comparator;

class Solution {
    
    // 그래프
    static List<List<Node>> graph = new ArrayList<>();
    
    // 걸리는 시간 배열
    static int[] time;
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        
        // 방문 배열 초기화
        time = new int[N + 1];
        Arrays.fill(time, Integer.MAX_VALUE);
        time[1] = 0; 
        
        // 그래프 초기화
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        
        // 그래프 연결 세팅
        for (int i = 0; i < road.length; i++) {
            int[] r = road[i];
            graph.get(r[0]).add(new Node(r[1], r[2]));
            graph.get(r[1]).add(new Node(r[0], r[2]));
        }
        
        dijkstra();
        
        for (int i = 1; i <= N; i++) {
            if (time[i] <= K) {
                answer++;
            }
        }

        return answer;
    }
    
    private static void dijkstra() {
        
        // 1번 마을 큐에 최초 삽입
        PriorityQueue<Node> queue = new PriorityQueue<>(new NodeComparator());
        queue.offer(new Node(1, time[1]));
        
        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();     
            if (time[currentNode.getNode()] < currentNode.getHour()) {
                continue;
            }   
            List<Node> nodeList = graph.get(currentNode.getNode());
            for (Node node : nodeList) {                                       
                if (time[node.getNode()] > node.getHour() + currentNode.getHour()) {
                    time[node.getNode()] = node.getHour() + currentNode.getHour();
                    queue.offer(new Node(node.getNode(), time[node.getNode()]));
                }
            }
        }
    }
}

// 노드
class Node {
    
    // 노드 번호
    private int node;
    
    // 걸리는 시간
    private int hour;
    
    Node(int node, int hour) {
        this.node = node;
        this.hour = hour;
    }
    
    public int getNode() {
        return this.node;        
    }
    
    public int getHour() {
        return this.hour;
    }
    
    @Override
    public String toString() {
        return String.format("노드 %d, 거리 %d", this.node, this.hour);
    }
    
}

class NodeComparator implements Comparator<Node> {
    
    @Override
    public int compare(Node node1, Node node2) {
        return node1.getHour() - node2.getHour(); 
    }
    
}