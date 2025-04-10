import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        if (n == 0 || n == 1) {
            System.out.println(n);
            return;
        }    
        
        long[] dp = new long[n + 1];
        dp[0] = 0L;
        dp[1] = 1L;
    
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
    
        System.out.println(dp[n]);
    
    }    
}

