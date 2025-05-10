import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int solution(String[][] book_time) {
        
        int[][] time = new int[book_time.length][2];
        
        for (int i = 0; i < book_time.length; i++) {
            time[i][0] = convertStrTimeToInt(book_time[i][0]);
            // 종료 시간에 청소 시간까지 포함
            time[i][1] = convertStrTimeToInt(book_time[i][1]) + 10;
        }
        
        // 입실 시간 기준으로 오름차순 정렬
        Arrays.sort(time, (t1, t2) -> t1[0] - t2[0]);
        
        // 대실 가능한 방의 개수 구하기
        int answer = checkRoomAvailability(time);
        
        return answer;
    }
    
    private int checkRoomAvailability(int[][] time) {
        
        // 종료 시간 기준으로 우선순위 큐 생성
        PriorityQueue<int[]> queue = new PriorityQueue<>((t1, t2) -> t1[1] - t2[1]);
        // 제일 처음 대실 이력 넣기
        queue.offer(time[0]);
        int cnt = 1;
        
        for (int i = 1; i < time.length; i++) {
            int[] current = queue.peek();
            // 대실된 방이 있고 대실 종료 시간이 도래해서 다음 대실할 방으로 쓸 수 있는 경우
            if (current != null && current[1] <= time[i][0]) {
                queue.poll();
                queue.offer(time[i]);
            } else {
                // 현재 방 생성이 되지 않았거나 대실 종료 시간이 되지 않아 새 방을 구해야 할 경우            
                queue.offer(time[i]);
                cnt++;
            }
        }
        return cnt;
    }
    
    // 시간 문자열 int로 변환
    private int convertStrTimeToInt(String time) {
        String[] timeArr = time.split(":");
        return Integer.parseInt(timeArr[0]) * 60 + Integer.parseInt(timeArr[1]);
    }
}