import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    
    static int[] sequence;
    
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // N, M, N개의 수를 입력으로 받는 배열
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] nums = new int[N];
        sequence = new int[M];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        
        // 수열 사전 순으로 증가하는 순서로 출력하기 위한 정렬
        Arrays.sort(nums);
        
        backtrack(nums, 0, M);
        
        System.out.println(sb.toString());
    }
    
    private static void backtrack(int[] nums, int depth, int maxDepth) {
        if (depth == maxDepth) {
            for (int element : sequence) {
                sb.append(element).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            sequence[depth] = nums[i];
            backtrack(nums, depth + 1, maxDepth);
        }
    }
}