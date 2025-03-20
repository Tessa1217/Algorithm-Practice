class Solution {
    
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int totalGrid = brown + yellow;
        
        for (int i = 3; i < totalGrid; i++) {
            if (totalGrid % i == 0) {
                int h = Math.max(i, totalGrid/i);
                int v = Math.min(i, totalGrid/i);
                int yellowArea = (h - 2) * (v - 2);
                if (yellow == yellowArea) {
                    answer = new int[]{h, v};
                    break;
                }
            }
        }
        
        return answer;
    }
    
}