import java.util.PriorityQueue;

class Solution {
    
    public int[] solution(int k, int[] score) {
        
        int[] answer = new int[score.length];
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int i = 0; i < score.length; i++) {
            // k 전까지는 삽입
            if (pq.size() < k) {
                pq.offer(score[i]);                                
            } else {
                // k 이후부터는 현재 peek 값이 score 값보다 작다면 교체
                if (pq.peek() < score[i]) {
                    pq.poll();
                    pq.offer(score[i]);
                }
            }
            // 최하위 점수 배열에 할당
            answer[i] = pq.peek();
        }
        return answer;
    }
}