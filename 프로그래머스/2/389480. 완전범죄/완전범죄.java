import java.util.HashSet;
import java.util.Set;
class Solution {
    
    private int N, M;
    
    private int min_a = Integer.MAX_VALUE;
    
    private Set<String> visited = new HashSet<>();
    
    public int solution(int[][] info, int n, int m) {        
        N = n; 
        M = m;
        dfs(0, 0, 0, info);
        if (min_a == Integer.MAX_VALUE) {
            return -1;
        }
        return min_a;
    }
    
    private void dfs(int idx, int thief_a, int thief_b, int[][] info) {
        // 성공적으로 훔칠 수 없다면
        if (thief_a >= N || thief_b >= M) {
            return;
        }
        // 이미 최소값보다 크다면
        if (min_a == 0 || thief_a >= min_a) {
            return;
        }
        
        String state = idx + "," + thief_a + "," + thief_b;
        if (visited.contains(state)) return;
        visited.add(state);
        
        if (idx == info.length) {
            min_a = Math.min(thief_a, min_a);
            return;
        }
        
        dfs(idx + 1, thief_a + info[idx][0], thief_b, info);
        dfs(idx + 1, thief_a, thief_b  + info[idx][1], info);
    }
}