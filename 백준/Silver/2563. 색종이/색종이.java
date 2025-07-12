import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
           
        boolean[][] 도화지 = new boolean[100][100];
        
        for (int i = 0; i < N; i++) {            
            String[] splitted_input = br.readLine().split(" ");
            attach(도화지, Integer.parseInt(splitted_input[0]), Integer.parseInt(splitted_input[1]));
        }       
        
        calculate(도화지);
    }
    
    public static void attach(boolean[][] 도화지, int 좌표1, int 좌표2) {
        for(int x = 좌표1; x < 좌표1+10; x++) {
            for(int y = 좌표2; y < 좌표2+10; y++) {
                도화지[x][y] = true;
            }
        }
    }

    public static void calculate(boolean[][] 도화지) {
        int result = 0;
        for(int x = 0; x < 100; x++) {
            for(int y=0; y<100; y++) {
                if(도화지[x][y]){
                    result++;
                }
            }
        }
        System.out.println(result);
    }
}