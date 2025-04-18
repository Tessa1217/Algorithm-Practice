import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    
    static int[] sequence;
    
    static boolean[] visited;
    
    static StringBuilder sb = new StringBuilder(); 
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 기본 변수 세팅
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] nums = new int[N];
        visited = new boolean[N];
        sequence = new int[M];
        
        // 인풋으로 들어오는 숫자 배열 세팅
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        
        // 오름차순으로 출력하기 위해 배열 정렬
        Arrays.sort(nums);
        
        backtrack(nums, 0, 0, M);
        
        System.out.println(sb.toString());
    }
    
    private static void backtrack(int[] nums, int start, int depth, int maxDepth) {
        if (depth == maxDepth) {
            for (int num : sequence) {
                sb.append(num)
                  .append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                sequence[depth] = nums[i];
                backtrack(nums, i, depth + 1, maxDepth);
                visited[i] = false;
            }
        }
    }
}