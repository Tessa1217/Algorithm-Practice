import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<Integer> solution(String msg) {
        int[] answer = {};
        
        Map<String, Integer> dic = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            dic.put(String.valueOf((char) (65 + i)), i + 1);      
        }
        
        List<Integer> indexList = new ArrayList<>();
        
        for (int i = 0; i < msg.length(); i++) {
            
            String letter = "";
            
            while (i < msg.length() && dic.containsKey(letter + msg.charAt(i))) {
                letter += msg.charAt(i);
                i++;
            }
            
            indexList.add(dic.get(letter));
            
            if (i < msg.length()) {
                dic.put(letter + msg.charAt(i), dic.size() + 1);
                i--;
            }
        }
        
        return indexList;
    }
}