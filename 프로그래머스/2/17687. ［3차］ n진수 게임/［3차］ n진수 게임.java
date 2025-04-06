class Solution {
    public String solution(int n, int t, int m, int p) {
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t * m; i++) {
            sb.append(Integer.toString(i, n).toUpperCase());            
        }

        String[] arr = sb.toString().split("");
        sb.setLength(0);
        for (int i = 0; i < t * m; i++) {
            if (i % m == p - 1) {
                sb.append(arr[i]);
            }
        }        
        return sb.toString();
    }
}