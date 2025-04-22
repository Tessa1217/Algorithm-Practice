import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

class Solution {
    
    public int solution(int n, int[][] wires) {
        int answer = wires.length;
        List<List<Integer>> wireTree = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            wireTree.add(new ArrayList<>());
        }
        for (int i = 0; i < wires.length; i++) {            
            wireTree.get(wires[i][0]).add(wires[i][1]);
            wireTree.get(wires[i][1]).add(wires[i][0]);
        }
        
        for (int i = 0; i < wires.length; i++) {
            boolean[] visited = new boolean[n + 1];
            int network1 = bfs(wires[i][0], wires[i][1], wireTree, visited);            
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
            int wire = queue.poll();
            List<Integer> wireList = wireTree.get(wire);
            for (int next : wireList) {
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