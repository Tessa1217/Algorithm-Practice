import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    
    static StringBuilder sb = new StringBuilder();
    
    static boolean[] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // N, M
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] nums = new int[N];
        // 방문 배열 (중복되는 수 방지)
        visited = new boolean[N];
        
        // N개의 수
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        
        // 수열을 사전 순으로 증거하는 순서로 출력하기 위해 정렬
        Arrays.sort(nums);
        
        backtrack(nums, new ArrayList<>(), 0, M);
        
        System.out.println(sb.toString());
        
    }
    
    private static void backtrack(int[] nums, List<Integer> array, int depth, int maxDepth) {
        if (depth == maxDepth) {
            for (int num : array) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                array.add(nums[i]);
                backtrack(nums, array, depth + 1, maxDepth);
                array.remove(array.size() - 1);
                visited[i] = false;
            }
        }
    }
}