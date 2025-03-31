import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        // 1 = 1, 2 = 1, 3 = 1, 4 = 2 (1 + 1), 5 = 2 (1 + 1), 6 = 3 (1 + 2), 7 = 4 (2 + 2)...
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());                
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            long[] dp = new long[101];            
            dp[1] = 1L;
            dp[2] = 1L;                      
            // 점화식
            for (int i = 3; i <= N; i++) {
                dp[i] = dp[i - 3] + dp[i - 2];
            }
            sb.append(dp[N])
              .append("\n");
        }
        System.out.println(sb);
    }
}