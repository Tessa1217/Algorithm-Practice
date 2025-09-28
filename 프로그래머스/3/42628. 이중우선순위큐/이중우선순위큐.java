import java.util.PriorityQueue;
import java.util.Map;
import java.util.HashMap;

class Solution {
    public int[] solution(String[] operations) {                
        
        // min heap
        PriorityQueue<Integer> min_heap = new PriorityQueue<>((a, b) -> a - b);
        // max heap
        PriorityQueue<Integer> max_heap = new PriorityQueue<>((a, b) -> b - a);
        
        // 길이가지고는 동기화가 안 되는 것 같아서 Map으로 관리
        Map<Integer, Integer> countMap = new HashMap<>();
        
        for (String operation : operations) {
            
            String[] operation_array = operation.split(" ");
            Integer operation_num = Integer.parseInt(operation_array[1]);
            
            // Insert: 값을 양쪽 큐에 모두 삽입
            if ("I".equals(operation_array[0])) {
                min_heap.offer(operation_num);
                max_heap.offer(operation_num);
                countMap.put(operation_num, countMap.getOrDefault(operation_num, 0) + 1);
                continue;
            }
            
            // min => -45, 45, 97, 333, 653
            // max => 333, 45, -45, -642
            
            // 1 => 최댓값 삭제
            if (operation_num == 1) {
                pollNumber(max_heap, countMap);
                
            } else if (operation_num == -1) { // -1 => 최솟값 삭제
                pollNumber(min_heap, countMap);                             
            }
        }
        
        syncWithCountMap(min_heap, countMap);
        syncWithCountMap(max_heap, countMap);
        
        if (countMap.isEmpty()) {
            return new int[]{0, 0};
        }
        
            
        return new int[]{max_heap.peek(), min_heap.peek()};
    }
    
    private void pollNumber(PriorityQueue<Integer> queue, Map<Integer, Integer> countMap) {
        syncWithCountMap(queue, countMap);
        if (!queue.isEmpty()) {
            int polled_num = queue.poll();
            int count = countMap.get(polled_num) - 1;
            if (count == 0) countMap.remove(polled_num);
            else countMap.put(polled_num, count);
        }
    }
    
    private void syncWithCountMap(PriorityQueue<Integer> queue, Map<Integer, Integer> countMap) {
        while (!queue.isEmpty() && countMap.getOrDefault(queue.peek(), 0) == 0) {
            queue.poll();
        }
    }
}