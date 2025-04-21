import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    
    static int[] nArr;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        nArr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nArr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(nArr);
        
        int M = Integer.parseInt(br.readLine());        
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int m = Integer.parseInt(st.nextToken());
            if (binarySearch(m)) {
                sb.append("1").append("\n");
            } else {
                sb.append("0").append("\n");
            }
        }                  
        
        System.out.println(sb.toString());
    }
    
    private static boolean binarySearch(int n) {
        int left = 0;
        int right = nArr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nArr[mid] > n) {
                right = mid - 1;
            } else if (nArr[mid] < n) {
                left = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
