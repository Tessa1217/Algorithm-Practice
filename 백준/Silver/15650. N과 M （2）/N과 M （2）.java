import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    
    // 자연수, 수열 길이
    static int N, M;
    
    // 숫자 배열
    static int[] arr;
    
    // 방문 처리 배열
    static boolean[] visited;
    
    static StringBuilder sb = new StringBuilder();    
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        
        arr = new int[N + 1];
        visited = new boolean[N + 1];
        
        makeSequence(0, 1);
        
        System.out.println(sb);
        
    }
    
    // 중복되지 않은 수열 만들기
    private static void makeSequence(int depth, int start) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i])
                  .append(" ");
            }
            sb.append("\n");
            return;
        }
        
        for (int i = start; i <= N; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            arr[depth] = i;
            makeSequence(depth + 1, i + 1);
            visited[i] = false;
        }
    }
}