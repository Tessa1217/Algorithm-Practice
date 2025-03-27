import java.util.List;
import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        // 프로세스 진행
        List<Integer> processes = new ArrayList<>();
        
        // 대기 큐
        Queue<Integer> queue = new LinkedList<>();                        
        for (int i = 0; i < priorities.length; i++) {
            queue.offer(i);            
        }
        
        // 우선순위 배열 내림차순으로 정렬
        Integer[] sortedPriorities = Arrays.stream(priorities)
                                           .boxed()
                                           .toArray(Integer[]::new);
        
        Arrays.sort(sortedPriorities, Comparator.reverseOrder());        
        
        int idx = 0;
        
        while (!queue.isEmpty()) {
            
            // 대기중인 프로세스 꺼내기
            int process = queue.poll();
            
            // 우선순위 프로세스와 비교
            if (priorities[process] < sortedPriorities[idx]) {
                // 꺼낸 프로세스보다 우선순위 높은 프로세스가 있을 경우 다시 넣기
                queue.offer(process);
                continue;
            }
                            
            // 우선순위가 높은 프로세스는 실행 및 우선순위 갈기
            processes.add(process);
            idx++;
            
        }
        
        return processes.indexOf(location) + 1;
    }
}