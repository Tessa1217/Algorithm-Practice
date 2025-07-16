import java.util.Set;
import java.util.HashSet;
class Solution {
    public int solution(int[] elements) {
        
        // 길이가 1인 연속 부분 수열
        // 1, 4, 7, 9
        // 길이가 2인 연속 부분 수열
        // 7 + 9, 9 + 1, 1 + 1, 1 + 4, 4 + 7 => 16, 10, 2, 5, 11
        // 길이가 3인 연속 부분 수열
        // 7 + 9 + 1, 9 + 1 + 1, 1 + 1 + 4, 1 + 4 + 7, 4 + 7 + 9 => 17, 11, 6, 12, 20                
        
        Set<Integer> sum = new HashSet<>();
        int length = elements.length;
        
        // 한 요소를 기준으로 길이를 늘려가며 부분 수열 누적 계산
        // ex) elements[0] = 7
        for (int i = 0; i < length; i++) {
            int start = 0;
            // j == 0 ? 7
            // j == 1 ? 7 + 9 = 16
            // j == 2 ? 16 + 1 = 17 ...
            // 원형 수열이기 때문에 j % length로 계산
            for (int j = i; j < length + i; j++) {
                start += elements[j % length];                
                sum.add(start);
            }
        }
        
        return sum.size();
    }
}