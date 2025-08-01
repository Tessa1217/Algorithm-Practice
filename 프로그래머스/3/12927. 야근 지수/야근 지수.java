import java.util.PriorityQueue;
class Solution {
    public long solution(int n, int[] works) {
        
        PriorityQueue<Integer> work_queue = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < works.length; i++) {
            work_queue.add(works[i]);
        }
        
        while (n > 0 && !work_queue.isEmpty()) {
            Integer current_work = work_queue.poll();
            if (current_work > 0) {
                current_work -= 1;
                work_queue.add(current_work);
            }
            n--;
        }
        
        long answer = 0;
        while (!work_queue.isEmpty()) {
            answer += Math.pow(work_queue.poll(), 2);
        }
        
        return answer;
    }
}