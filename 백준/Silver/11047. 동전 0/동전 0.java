import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int[] coins = new int[N];
        
        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        
        int coinCnt = 0;
        
        for (int i = N - 1; i >= 0; i--) {
            if (K < coins[i]) {
                continue;
            }
            int cnt = K / coins[i];
            K -= cnt * coins[i];
            coinCnt += cnt;
            if (K == 0) {
                System.out.println(coinCnt);
                break;
            }            
        }
    }
}