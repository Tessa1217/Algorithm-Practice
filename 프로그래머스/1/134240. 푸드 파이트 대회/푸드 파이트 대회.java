import java.lang.StringBuffer;

class Solution {
    public String solution(int[] food) {
        
        StringBuffer sb = new StringBuffer();
        
        for (int i = 1; i < food.length; i++) {
            int foodLength = food[i] / 2;
            if (foodLength > 0) {
                for (int j = 0; j < foodLength; j++) {
                    sb.append(i);
                }   
            }
        }
        
        String answer = sb.toString() + "0";
        
        String reversed = sb.reverse().toString();
        
        return answer + reversed;
    }
}