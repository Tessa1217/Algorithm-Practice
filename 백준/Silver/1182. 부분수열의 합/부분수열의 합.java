import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.Stack;
import java.util.ArrayList;

public class Main {
    
    static int count;
    
    public static void main(String[] args) throws IOException {
        // 5 0
        // -7 -3 -2 5 8
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int[] nums = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        backtrack(nums, s, 0, 0, 0);
        System.out.println(count);
    }
    
    private static void backtrack(int[] nums, int target, int start, int cnt, int depth) {
        if (start == nums.length) {
            if (cnt == target && depth > 0) {
                count++;               
            }           
            return;
        }
     
        backtrack(nums, target, start + 1, cnt + nums[start], depth + 1);
        backtrack(nums, target, start + 1, cnt, depth);
    }
}