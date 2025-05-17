import java.util.Stack;
class Solution {
    public int[] solution(int[] prices) {
        
        int[] answer = new int[prices.length];
        
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < prices.length - 1; i++) {                                    
            for (int j = i + 1; j < prices.length; j++) {                
                answer[i]++;
                if (prices[i] > prices[j]) {
                    break;
                }                
            }    
            
        }
        
        return answer;
    }
}