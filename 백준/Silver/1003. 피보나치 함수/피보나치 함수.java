import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    
    static Integer[][] dp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());        
        
        StringBuilder sb = new StringBuilder();
        dp = new Integer[41][2];
        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;
        
        for (int i = 0; i < n; i++) {            
            int c = Integer.parseInt(br.readLine());
            fibonacci(c);
            sb.append(dp[c][0]).append(" ").append(dp[c][1]).append("\n");            
        }

        System.out.println(sb);
        
    }
    
    private static Integer[] fibonacci(int n) {
        if (dp[n][0] == null && dp[n][1] == null) {
            dp[n][0] = fibonacci(n - 1)[0] + fibonacci(n - 2)[0];
            dp[n][1] = fibonacci(n - 1)[1] + fibonacci(n - 2)[1];
        }
        return dp[n];
    }
}