import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 사람의 수
        int N = Integer.parseInt(br.readLine());        
        // 사람 배열
        int[] people = new int[N];        
        // 시간 배열
        int[] time = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            people[i] = Integer.parseInt(st.nextToken());
        }                
        
        // 뽑는 시간 기준으로 오름차순 정렬
        Arrays.sort(people);
        
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                time[j] += people[i];
            }
        }
        
        int totalTime = Arrays.stream(time)
                              .sum();
        
        System.out.println(totalTime);
        
    }
    
}