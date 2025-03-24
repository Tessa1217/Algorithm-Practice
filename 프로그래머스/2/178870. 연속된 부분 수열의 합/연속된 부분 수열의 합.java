class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        
        // 좌, 우측 포인터
        int l = 0; 
        int r = 0;
        
        // 수열의 합
        int sum = 0;
        // 부분 수열의 길이
        int partialArrLength = sequence.length;
        
        for (r = 0; r < sequence.length; r++) {
            sum += sequence[r];
            // 좌측 포인터 이동
            while (r < sequence.length && sum > k) {
                sum -= sequence[l];
                l++;
            }
            if (sum == k) {
                // 부분 수열의 길이 작은 것으로 세팅
                if (partialArrLength > r - l) {
                    partialArrLength = r - l;
                    answer[0] = l;
                    answer[1] = r;                    
                }
            }
        }
        
        return answer;
    }
}