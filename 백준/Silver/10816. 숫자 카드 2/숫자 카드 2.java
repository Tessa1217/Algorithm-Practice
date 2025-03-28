import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    
    static int[] arr;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        
        int M = Integer.parseInt(br.readLine());
        StringTokenizer ster = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(ster.nextToken());
            sb.append(binaryHigherBound(0, N, num) - binaryLowerBound(0, N, num))
              .append(" ");
        }
        System.out.println(sb);
    }
    
    private static int binaryLowerBound(int start, int end, int target) {
        int mid;
        while (start < end) {
            mid = (start + end) / 2;
            if (target <= arr[mid]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;        
    }
    
    private static int binaryHigherBound(int start, int end, int target) {
        int mid;
        while (start < end) {
            mid = (start + end) / 2;
            if (target < arr[mid]) {
                end = mid;
            } else {
                start = mid + 1;
            }  
        }
        return start;
    }
}