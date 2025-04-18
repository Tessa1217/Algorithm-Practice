import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;

public class Main {
    
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int k = Integer.parseInt(st.nextToken());
            if (k == 0) {
                break;
            }
            
            int[] nums = new int[k];
            for (int i = 0; i < k; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }
            
            backtrack(nums, new ArrayList<>(), 0, 0);
            sb.append("\n");
        }
        
        System.out.println(sb.toString());
    }
    
    private static void backtrack(int[] nums, List<Integer> numList, int start, int depth) {
        // 6 숫자 다 뽑았으면
        if (depth == 6) {
            for (int num : numList) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = start; i < nums.length; i++) {
            numList.add(nums[i]);
            backtrack(nums, numList, i + 1, depth + 1);
            numList.remove(numList.size() - 1);
        }
    }
}