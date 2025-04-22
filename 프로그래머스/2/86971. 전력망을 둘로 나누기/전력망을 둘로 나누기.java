import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.stream.IntStream;
import java.util.stream.Collectors;

class Solution {
    
    public int solution(int n, int[][] wires) {
        
        int answer = wires.length;
        
        // 전력망 구조 세팅
        
        List<List<Integer>> wireTree = IntStream.rangeClosed(0, n)
                                                .mapToObj(i -> new ArrayList<Integer>())
                                                .collect(Collectors.toList());

        for (int[] wire : wires) {            
            wireTree.get(wire[0]).add(wire[1]);
            wireTree.get(wire[1]).add(wire[0]);
        }
        
        // 전선 연결에 따라 나누어진 두 전력망 각각의 송전탑 개수 계산
        for (int[] wire : wires) {
            boolean[] visited = new boolean[n + 1];
            int network1 = bfs(wire[0], wire[1], wireTree, visited);            
            int network2 = n - network1;
            answer = Math.min(answer, Math.abs(network1 - network2));            
        }
        
        
        
        return answer;
    }
    
    private int bfs(int connectWire, int cutOffWire, 
                    List<List<Integer>> wireTree, boolean[] visited) {
        
        int count = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(connectWire);        
        visited[connectWire] = true;
        
        while (!queue.isEmpty()) {
            
            int current = queue.poll();
            
            for (int next : wireTree.get(current)) {
                // 방문 처리 되지 않았으면서 끊으려는 전선이 아닌 경우
                if (!visited[next] && next != cutOffWire) {
                    visited[next] = true;
                    queue.offer(next);
                    count++;
                }
            }
        }
        return count;
    }
    
    
}
