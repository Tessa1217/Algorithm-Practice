import java.util.Map;
import java.util.HashMap;

class Solution {
    
    // 전체 요소 개수
    static int elemCnt = 0;
    
    public int solution(String str1, String str2) {
        
        int answer = 0;
        
        // 공통 요소 교집합
        int c = 0;
        
        Map<String, Integer> str1Map = generateWordMap(str1);        
        Map<String, Integer> str2Map = generateWordMap(str2);
        
        for (String key : str1Map.keySet()) {
            for (String key2 : str2Map.keySet()) {
                if (key.equals(key2)) {
                    c += Math.min(str1Map.get(key), str2Map.get(key));
                }
            }
        }
        
        // 합집합
        int a = elemCnt - c;
        
        float j;
        
        if (a == 0 && c == 0) {
            j = 65536;
        } else {
            j = ((float) c / (float) a) * (float) 65536;   
        }
        
        return (int) j;
    }
    
    private static Map<String, Integer> generateWordMap(String str) {
        int cnt = 0;
        str = str.toLowerCase();
        Map<String, Integer> strMap = new HashMap<>();
        for (int i = 0; i < str.length() - 1; i++) {
            String word = str.substring(i, i + 2);
            if (word.matches("[a-z]+")) {
                cnt++;
                strMap.put(word, strMap.getOrDefault(word, 0) + 1);
            }
        }
        elemCnt += cnt;
        return strMap;
    }
}