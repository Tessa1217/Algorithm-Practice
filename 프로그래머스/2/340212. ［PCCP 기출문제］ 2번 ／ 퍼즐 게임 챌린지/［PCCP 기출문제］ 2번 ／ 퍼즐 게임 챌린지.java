class Solution {
    
    // 숙련도에 따른 퍼즐 통과 시간
    private long passPuzzleTime (int[] diffs, int[] times, int level, long limit) {
        long totalTime = 0;
        for (int i = 0; i < diffs.length; i++) {
            int time_prev = (i == 0) ? 0 : times[i - 1];
            int time_cur = times[i];
            int levelDiff = diffs[i] - level;
            if (levelDiff >= 0) {
                totalTime += (long) (time_cur + time_prev) * levelDiff + time_cur;                
            } else {
                totalTime += (long) time_cur;
            }
            if (limit < totalTime) {
                return totalTime;
            }
        }
        return totalTime;
        
    }
    public int solution(int[] diffs, int[] times, long limit) {

        // 숙련
        int start = 1; 
        int level = 0;
        int end = 100000; 
        while (start <= end) {
            int midLevel = (start + end) / 2;
            long passTime = passPuzzleTime(diffs, times, midLevel, limit);
            if (passTime <= limit) {
                level = midLevel;
                // 30000
                // 1 ~ 29999 => 중간을 찾아서
                // 15000
                // 1 ~ 14999 => 중간 
                end = midLevel - 1;   
                // end = midLevel;
            } else {
                start = midLevel + 1;
                // start = midLevel;
            }   

        }
        return level;
    }
}