import java.util.List;
import java.util.ArrayList;

class Solution {
    public int solution(int n, int w, int num) {        
        
        // 택배 창고에 쌓인 택배의 높이
        int h = n % w == 0 ? n / w : n / w + 1;
        
        // 택배 배열
        int[][] boxes = new int[h][w];
        
        // 택배가 있는 위치 좌표
        int[] currentBoxPosition = new int[2];
        
        // 택배 배열 그리기
        for (int i = 0; i < h; i++) {   
            for (int j = 0; j < w; j++) {  
                int x = i % 2 == 0 ? (j + 1) : w - j;
                int boxNum = (w * i) + x > n ? 0 : (w * i) + x;
                boxes[i][j] = boxNum;
                if (boxNum == num) {
                    currentBoxPosition[0] = i;
                    currentBoxPosition[1] = j;                    
                }
            }
        }
        
        // 현재 택배의 높이
        int height = currentBoxPosition[0];
        // 꺼내야 하는 택배 상자 개수 (실제 상자 포함)
        int answer = 1;
        
        while (true) {
            if (height == h - 1) {
                break;
            }
            height++;
            answer++;    
            // 최대 높이까지 도달은 안 했지만 택배 상자가 없는 경우 
            // (n이 w의 배수가 아니라 상자 배열 꽉 안 차는 경우)
            if (boxes[height][currentBoxPosition[1]] == 0) {
                answer--;
                break;
            }            
        }
        
        return answer;        
    }
}