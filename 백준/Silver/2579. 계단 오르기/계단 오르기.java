import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
 
	static int[] dp;

    static int[] stair;
 
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        stair = new int[n + 1];
        dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
          stair[i] = Integer.parseInt(br.readLine());
        }
                
        dp[1] = stair[1];
        if (n >= 2) {
            dp[2] = stair[1] + stair[2];
        }        

        for (int i = 3; i <= n; i++) {
          dp[i] = Math.max(stair[i] + stair[i - 1] + dp[i - 3], stair[i] + dp[i - 2]);
        }

        System.out.println(dp[n]);
 
	}
 
}