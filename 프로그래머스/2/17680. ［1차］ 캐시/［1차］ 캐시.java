import java.util.List;
import java.util.ArrayList;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        // 캐시 크기가 0이라면, 전부 cache miss
        if (cacheSize == 0) {
            return cities.length * 5;
        }
        
        List<String> cachedCities = new ArrayList<>();
        int answer = 0;
        for (String city : cities) {
            city = city.toLowerCase();
            if (!cachedCities.contains(city)) {
                if (cachedCities.size() == cacheSize) {
                    cachedCities.remove(0);   
                }                
                cachedCities.add(city);
                answer += 5;
            } else {
                cachedCities.remove(city);
                cachedCities.add(city);
                answer += 1;
            }
            
        }
        return answer;
    }
}