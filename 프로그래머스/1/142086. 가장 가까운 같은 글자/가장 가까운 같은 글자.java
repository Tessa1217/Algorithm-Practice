import java.util.Map;
import java.util.HashMap;

class Solution {
    
    public int[] solution(String s) {
        
        int[] answer = new int[s.length()];
        
        Map<Character, Integer> locMap = new HashMap<>();
        
        char[] letters = s.toCharArray();
        for (int i = 0; i < letters.length; i++) {
            int position = locMap.getOrDefault(letters[i], -1);
            answer[i] = position == -1 ? -1 : i - position;
            locMap.put(letters[i], i);
        }
        
        return answer;
    }
}