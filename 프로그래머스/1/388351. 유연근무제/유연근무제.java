class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        
        int answer = schedules.length;
        
        for (int i = 0; i < schedules.length; i++) {
            // 직원의 출근 인정 시각
            int safe = calculateSafeTime(schedules[i]);
            // 한 직원의 한 주 스케줄
            int[] timelog = timelogs[i];
            for (int j = 0; j < timelog.length; j++) {                
                int today = (startday + j) % 7;
                // 토요일, 일요일은 영향 주지 않음
                if (today % 6 == 0 || today % 7 == 0) {
                    continue;
                }
                
                int startTime = timelog[j];
                
                // 출근 인정 시각 내 출근하지 못한 경우
                if (startTime > safe) {
                    answer--;
                    break;
                }
            }
        }
        return answer;
    }
    
    private static int calculateSafeTime(int time) {
        
        int h = time / 100;
        int m = time % 100;
        
        if (m + 10 >= 60) {
            return (h + 1) * 100 + (m + 10 - 60);
        } else {
            return h * 100 + (m + 10);
        }
        
    }
}