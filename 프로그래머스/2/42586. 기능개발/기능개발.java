import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        //  배포 정보 담는 배열
        List<Integer> deployment = new ArrayList<>();
        // 작업일수 저장 큐
        Queue<Integer> queue = new LinkedList<>();
        
        // speed를 기준으로 현재 작업이 얼만큼 걸리는지 작업일수 구하기
        for (int i = 0; i < progresses.length; i++) {
            int left = 100 - progresses[i];            
            int duration = left / speeds[i];
            if (left % speeds[i] != 0) {
                duration += 1;
            }
            queue.offer(duration);
        }
        
        int first = queue.poll();
        int count = 1;
        
        while (!queue.isEmpty()) {
            // 기준이 되는 작업일수보다 작다면 (현재 배포 일수 기준 이전에 완료되면 같이 배포)
            if (queue.peek() <= first) {
                count++;
                queue.poll();
            } else {
                deployment.add(count);
                count = 1;
                first = queue.poll();
            }
        }
        deployment.add(count);
        
        int[] answer = new int[deployment.size()];
        
        for (int i = 0; i < deployment.size(); i++) {
            answer[i] = deployment.get(i);
        }
        
        return answer;
    }
}