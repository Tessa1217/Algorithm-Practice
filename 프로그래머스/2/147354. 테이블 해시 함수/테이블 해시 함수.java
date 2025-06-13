import java.util.Arrays;
class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        
        int answer = 0;
        
        Arrays.sort(data, (d1, d2) -> {
            int c = Integer.compare(d1[col - 1], d2[col - 1]);
            if (c == 0) {
                return Integer.compare(d2[0], d1[0]);
            }
            return c;            
        });
        
        for (int i = row_begin; i <= row_end; i++) {
            int row = i;            
            int S_i = Arrays.stream(data[row - 1])
                            .map(d -> d % row)                            
                            .sum();
            answer = answer ^ S_i;
        }
        
        return answer;
    }
}