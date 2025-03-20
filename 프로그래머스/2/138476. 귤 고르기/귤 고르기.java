import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

class Solution {
    public int solution(int k, int[] tangerine) {
        
        int answer = 0;
        
        
        Map<Integer, Integer> tangCntMap = new HashMap<>();
        for (int i = 0; i < tangerine.length; i++) {
            int cnt = tangCntMap.getOrDefault(tangerine[i], 0);
            tangCntMap.put(tangerine[i], cnt + 1);
        }
        
        List<Integer> tangKeys = new ArrayList<>(tangCntMap.keySet());
        
        tangKeys.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer cnt1, Integer cnt2) {
                return tangCntMap.get(cnt2) - tangCntMap.get(cnt1);
            }
        });
            
        int prevTang = 0;    
            
        for (Integer tang : tangKeys) {
            k -= tangCntMap.get(tang);
            if (prevTang != tang) {
                prevTang = tang;
                answer++;
            }
            if (k <= 0) {
                break;
            }            
        }    
        
        return answer;
    }
}