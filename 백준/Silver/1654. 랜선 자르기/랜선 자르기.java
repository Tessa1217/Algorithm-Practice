import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    
    static long[] arr;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        arr = new long[K];
        
        long max = 0;
        
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(arr[i], max);
        }
        
        // 0으로 나누기 방지를 위해서 + 1
        max += 1;
        
        long cnt = binaryHigherBound(0, max, N);
        System.out.println(cnt - 1);        
        
    }
    
    private static long binaryHigherBound (long start, long end, long target) {
        long mid;
        while (start < end) {
            mid = (start + end) / 2;
            // 최대  만들 수 있는 랜선 수
            long lines = 0;
            for (int i = 0; i < arr.length; i++) {
                lines += (arr[i] / mid);
            }
            if (lines < target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}