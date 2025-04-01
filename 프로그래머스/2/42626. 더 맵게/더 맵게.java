import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < scoville.length; i++) {
            queue.add(scoville[i]);
        }
        
        while (!queue.isEmpty()) {
            if (queue.peek() >= K) {
                break;
            }
            int s1 = queue.poll();
            if (queue.peek() == null) {
                answer = -1;
                break;
            }
            int s2 = queue.poll();
            answer++;
            queue.offer(newScoville(s1, s2));
        }
        return answer;
    }
    
    private static int newScoville(int s1, int s2) {
        return s1 + (s2 * 2);
    }
}