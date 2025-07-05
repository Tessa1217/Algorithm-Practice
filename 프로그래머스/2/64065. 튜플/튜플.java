import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
class Solution {
    public Integer[] solution(String s) {        
        
        String[] parsedArr = s.substring(2, s.length() - 2).split("\\}\\,\\{");
        
        Arrays.sort(parsedArr, (a, b) -> a.length() - b.length());
        
        List<Integer> answer = new ArrayList<>();
        
        for (int i = 0; i < parsedArr.length; i++) {
            String[] arr = parsedArr[i].split(",");
            for (String numStr : arr) {
                Integer num = Integer.parseInt(numStr);                
                if (answer.indexOf(num) > -1) {
                    continue;
                } 
                answer.add(num);
            }            
        }
            
        return answer.toArray(new Integer[0]);
    }
}