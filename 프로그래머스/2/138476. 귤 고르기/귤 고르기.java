import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public int solution(int k, int[] tangerine) {
        
        int answer = 0;
        
        Map<Integer, Integer> tangCntMap = new HashMap<>();
        // 귤 크기에 따른 개수 맵에 저장
        for (int i = 0; i < tangerine.length; i++) {
            int cnt = tangCntMap.getOrDefault(tangerine[i], 0);
            tangCntMap.put(tangerine[i], cnt + 1);
        }
        
        // 귤 개수 기준으로 내림차순 정렬
        List<Integer> tangKeys = new ArrayList<>(tangCntMap.keySet());
        
        tangKeys.sort((k1, k2) -> tangCntMap.get(k2) - tangCntMap.get(k1));

        for (Integer tang : tangKeys) {
            k -= tangCntMap.get(tang);
            answer++;
            if (k <= 0) {
                break;
            }            
        }    
        
        return answer;
    }
}