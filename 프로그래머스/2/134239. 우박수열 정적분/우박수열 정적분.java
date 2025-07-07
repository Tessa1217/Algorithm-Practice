// 초항 k, x = 0, y = k, 다음 우박 수는 x = 1에 표시
// 우박수가 1이 될 때까지 점 찍기
// k = 5라면, (0, 5) => (1, 16) => (2, 8) => (3, 4) => (4, 2) => (5, 1)
// 꺾은선 그래프에 대한 정적분
// x에 대한 어떤 범위가 [a, b]라면 x = a, x = b, y = 0으로 둘러 쌓인 공간의 면적과 동일
// ex) [1, 2] => x = 1, x = b, y = 0
// 만약 범위가 [a, -b]라면 결과는 
// x = a, x = n - b, y = 0 => n은 k가 초항인 우박수열이 1이 될때 까지의 횟수를 의미
// [0, 0]에 대한 정적분은 x = 0, x  = 5 - 0, y = 0에 대한 정적분
// [1, -2]에 대한 정적분은 x = 1, x = 5 - 2 = 3, y = 0에 대한 정적분
// 전체 공간에 대한 정적분은
// 0 ~ 1 구간 => (5 + 16)/2 = 10.5
// 1 ~ 2 구간 => (16 + 8)/2 = 12
// 2 ~ 3 구간 => (8 + 4)/2 = 6
// 3 ~ 4 구간 => (4 + 2)/2 = 3
// 4 ~ 5 구간 => (2 + 1)/2 = 1.5
// 전체 구간 => 10.5 + 12 + 6 + 3 + 1.5 = 33.0
// [0, -1]이 주어진다면 x = 0, x = 5 - 1 = 4 => 0 <= x <= 4 => 10.5 + 12 + 6 + 3 = 31.5
// ...

import java.util.List;
import java.util.ArrayList;
class Solution {
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        
        // 콜라츠 추측으로 n과 각 영역에 대한 넓이 구하기
        List<Double> sizes = getSizeOfGraphRange(k);
        // 초항이 1이 될 때까지의 횟수 = 넓이 영역
        int n = sizes.size();
        
        for (int i = 0; i < ranges.length; i++) {
            
            int[] range = ranges[i];
            int a = range[0];
            int b = range[1] == 0 ? sizes.size() : n + range[1];
            
            // 영역 0
            if (a == b) {
                answer[i] = 0.0;
                continue;
            }
            // 유효하지 않은 구간
            if (a > b) {
                answer[i] = -1.0;
                continue;
            }
                        
            answer[i] = sizes.subList(a, b).stream().mapToDouble(num -> num).sum();    
        }
        return answer;
    }
    
    private List<Double> getSizeOfGraphRange(int k) {
        List<Double> sizes = new ArrayList<>();                
        int prev_x = k;        
        while (k > 1) {
            k = getCollatzNumber(k);            
            double size = (double) (prev_x + k) / 2;
            sizes.add(size);
            prev_x = k;            
        }
        return sizes;
    }
    
    private int getCollatzNumber(int k) {
        // 짝수라면 2로 나누기
        if (k % 2 == 0) {
            k /= 2;   
        } else {
            k = k * 3 + 1;
        }        
        return k;
    }
}