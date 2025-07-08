import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;
public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 전체 용액의 수
        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 용액 배열
        long[] arr = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        
        // 합을 구하기 위해 정렬
        Arrays.sort(arr);
        
        int start = 0;
        int end = N - 1;
        long close_to_zero_sum = Long.MAX_VALUE;
        StringBuilder sb = new StringBuilder();
        // 투 포인터 활용하여 두 용액의 합에 대한 절댓값 계산하여
        // 0에 근접한 용액 찾기
        while (start < end) {
            long sum = arr[start] + arr[end];
            // sum이 0이라면 0에 최대한 근접한 경우의 수이기 때문에 바로 break
            if (sum == 0) {
                sb.setLength(0);
                sb.append(arr[start]).append(" ").append(arr[end]);
                break;
            }
            
            // 0에 더 가까운 절댓값이라면
            if (close_to_zero_sum > Math.abs(sum)) {
                sb.setLength(0);
                sb.append(arr[start]).append(" ").append(arr[end]);
                close_to_zero_sum = Math.abs(sum);
            }
            
            if (sum > 0) {
                end--;
            } else {
                start++;
            }
        }
        
        System.out.println(sb.toString());
    }
    
}