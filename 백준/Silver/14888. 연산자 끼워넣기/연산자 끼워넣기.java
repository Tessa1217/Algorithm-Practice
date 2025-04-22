import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    
    static int MIN = Integer.MAX_VALUE;
    
    static int MAX = Integer.MIN_VALUE;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        int[] operators = new int[4];
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 주어진 수
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        // 연산자 정보: 덧셈, 뺄셈, 곱셈, 나눗셈 순서
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }
        backtrack(nums[0], 1, nums.length, nums, operators);
        
        System.out.println(MAX);
        System.out.println(MIN);
    }
    
    private static void backtrack(int num, int depth, int maxDepth, 
                                  int[] nums, int[] operators) {
        if (depth == maxDepth) {
            MIN = Math.min(num, MIN);
            MAX = Math.max(num, MAX);
            return;
        }
        
        for (int i = 0; i < operators.length; i++) {
            if (operators[i] == 0) {
                continue;
            }
            operators[i]--;
            if (i == 0) {
                backtrack(num + nums[depth], depth + 1, maxDepth, nums, operators);
            } else if (i == 1) {
                backtrack(num - nums[depth], depth + 1, maxDepth, nums, operators);    
            } else if (i == 2) {
                backtrack(num * nums[depth], depth + 1, maxDepth, nums, operators);    
            } else if (i == 3) {
                backtrack(num / nums[depth], depth + 1, maxDepth, nums, operators);    
            }
            operators[i]++;
        }
    }
}