class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        
        for (int i = 0; i <= d; i += k) {
            long c = (long) Math.sqrt(Math.pow(d, 2) - Math.pow(i, 2));
            // 0 포함
            answer += (long) c / k + 1; 
        }
        return answer;
    }
}