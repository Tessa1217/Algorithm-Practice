import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
                
        Integer[] arr1 = new Integer[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        
        Integer[] arr2 = new Integer[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr1);
        Arrays.sort(arr2, Collections.reverseOrder());
        
        int num = 0;
        for (int i = 0; i < n; i++) {
            num += (arr1[i] * arr2[i]);
        }
            
        System.out.println(num);
        
    }
    
    
}