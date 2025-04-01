import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    
    static int n;
    
    static int[][] arr;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < i + 1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int max = arr[0][0];
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                arr[i][j] += Math.max(getRangeValue(i - 1, j), getRangeValue(i - 1, j - 1));
                max = Math.max(arr[i][j], max);
            }
        }
        
        System.out.println(max);
    }
    
    private static int getRangeValue(int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= n) {
            return 0;
        }
        return arr[x][y];
    }
    
}