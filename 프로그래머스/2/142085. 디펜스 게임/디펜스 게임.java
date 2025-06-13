import java.util.Arrays;
import java.util.PriorityQueue;
class Solution {
    public int solution(int n, int k, int[] enemy) {
        
        // 적군의 수가 무적권의 수보다 작거나 같다면
        if (enemy.length <= k) {
            // 모든 라운드 커버 가능
            return enemy.length;
        }
        
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int e : enemy) {
            // 무적권이 남아있는 동안
            if (k > 0) {
                // 무적권 소모
                k--;        
                // 현재 라운드의 적의 수 PriorityQueue에 삽입
                pq.offer(e);
            } else {
                // 현재 최소 적의 수 poll
                int least = pq.poll();
                // 만약 현재 적의 수가 poll된 수보다 크다면
                if (least < e) {                                          
                    pq.offer(e);
                    n -= least;
                } else {                                    
                    pq.offer(least);                    
                    n -= e;    
                }    
                // 더는 싸울 수 없으면 break
                if (n < 0) break;
            }
            answer++;            
        }
        
        return answer;
    }
}