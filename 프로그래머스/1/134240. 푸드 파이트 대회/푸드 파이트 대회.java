import java.lang.StringBuffer;

class Solution {
    public String solution(int[] food) {
        
        StringBuffer sb = new StringBuffer();
        
        for (int i = 1; i < food.length; i++) {
            int foodLength = food[i] / 2;
            // 문자열 반복 메서드: repeat(int count)
            sb.append(String.valueOf(i).repeat(foodLength));
        }
        
        String answer = sb.toString() + "0";
        
        String reversed = sb.reverse().toString();
        
        return answer + reversed;
    }
}