class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int curOneCnt = countOneInBinary(n);
        for (int i = n + 1; i <= 1000000; i++) {
           int nextOneCnt = countOneInBinary(i);
            if (curOneCnt == nextOneCnt) {
                answer = i;
                break;
            }
        }
        return answer;
    }
    
    private static int countOneInBinary(int num) {
        int cnt = 1;
        while (num > 1) {
            if (num % 2 == 1) {
                cnt++;
            }
            num /= 2;
        }
        return cnt;
    }
    
}