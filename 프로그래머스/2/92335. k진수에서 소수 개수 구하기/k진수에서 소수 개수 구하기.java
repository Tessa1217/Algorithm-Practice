class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        String[] converted_num = Integer.toString(n, k).split("0");
        
        for (String num : converted_num) {
            if (num.isEmpty()) {
                continue;
            }            
            answer += is_prime_number(Long.parseLong(num)) ? 1 : 0;
        }
        return answer;
    }
    
    private boolean is_prime_number(long num) {
        if (num < 2) {
            return false;
        }
        for (long i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}