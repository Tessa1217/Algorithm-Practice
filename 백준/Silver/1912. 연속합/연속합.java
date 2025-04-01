import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));              
        
        // 정수 개수
        int n = Integer.parseInt(br.readLine());
        
        // 정수 배열
        int[] arr = new int[n];
        
        String[] numStrArr = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(numStrArr[i]);
        }
        
        for (int i = 1; i < n; i++) {
            arr[i] = Math.max(arr[i] + arr[i - 1], arr[i]);
        } 
        
        System.out.println(Arrays.stream(arr).max().getAsInt());
        
    }
}