class Solution {
    public String solution(String number, int k) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        // number의 자릿수 - k 만큼
        for (int i = 0; i < number.length() - k; i++) {
            char max = 0;
            // k 구간 세팅 후 그 구간에서 가장 큰 수 선택
            for (int j = idx; j <= i + k; j++) {
                if (max < number.charAt(j)) {
                    max = number.charAt(j);
                    // 선택한 수 다음 인덱스부터 탐색 범위 한 칸씩 늘려가며 반복
                    idx = j + 1;
                }
            }
            sb.append(max);
        }
        return sb.toString();
    }
}