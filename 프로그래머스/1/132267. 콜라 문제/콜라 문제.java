class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        
        while (n >= a) {
           int d = n / a;
           answer += d * b;
           // 새로운 콜라병의 개수 : 기존 콜라병 수 - 변경 수령한 콜라병 수 + 새로 수령한 콜라병의 수
           n = n - (d * a) + (d * b);
        }
        
        return answer;
    }
}