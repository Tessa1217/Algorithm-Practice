import java.util.Map;
import java.util.HashMap;
import java.lang.StringBuilder;

class Solution {
    
    public String solution(int[] numbers, String hand) {
        
        // 키패드 좌표 해쉬맵
        Map<String, int[]> digits = initDigits();
        
        // 엄지손가락 시작 포지션
        int[] leftPosition = digits.get("*"); 
        int[] rightPosition = digits.get("#");
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < numbers.length; i++) {
            
            // 현재 키패드의 좌표
            int[] matrix = digits.get(String.valueOf(numbers[i]));
            
            if (numbers[i] != 0 && numbers[i] % 3 == 0) { // 오른쪽 키패드 입력 영역
                sb.append("R");
                rightPosition = matrix;                
            } else if (numbers[i] % 3 == 1) { // 왼쪽 키패드 입력 영역
                sb.append("L");
                leftPosition = matrix;                
            } else {
                
                // 키패드간 거리 측정
                int leftDistance = getPosition(matrix, leftPosition);
                int rightDistance = getPosition(matrix, rightPosition);
                
                if (leftDistance == rightDistance) { // 동일한 경우 주 손 비교
                    if ("left".equals(hand)) {
                        sb.append("L");
                        leftPosition = matrix;
                    } else if ("right".equals(hand)) {
                        sb.append("R");
                        rightPosition = matrix;
                    }
                } else if (leftDistance  < rightDistance) {
                    sb.append("L");
                    leftPosition = matrix;
                } else {
                    sb.append("R");
                    rightPosition = matrix;
                }
            }
            
        }
        
        return sb.toString();
    }
    
    // 키패드 세팅
    private Map<String, int[]> initDigits() {
        
        Map<String, int[]> digits = new HashMap<>();
        
        // 0, *, # 먼저 세팅
        digits.put("*", new int[]{3, 0});
        digits.put("0", new int[]{3, 1});
        digits.put("#", new int[]{3, 2});
        
        int x = 0;
        int y = 0;
        
        for (int i = 1; i <= 9; i++) {
            digits.put(String.valueOf(i), new int[]{y, x});
            if (i % 3 == 0) {
                x = 0;
                y++;
            } else {
                x++;
            }            
        } 
        
        return digits;
    }
    
    private int getPosition(int[] matrix, int[] handMatrix) {
        return Math.abs(matrix[0] - handMatrix[0]) + Math.abs(matrix[1] - handMatrix[1]);
    }
    
    
}