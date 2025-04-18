import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.stream.IntStream;
import java.util.List;
import java.util.ArrayList;

public class Main {
    
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputArr = br.readLine().split(" ");
        
        int N = Integer.parseInt(inputArr[0]);
        int M = Integer.parseInt(inputArr[1]);
        
        int[] nums = IntStream.rangeClosed(1, N)
                              .toArray();
        
        backtrack(nums, new ArrayList<>(), 0, 0, M);
        
        System.out.println(sb.toString());
    }
    
    private static void backtrack(int[] nums, List<Integer> array, int start, int depth, int maxDepth) {
        if (depth == maxDepth) {
            for (int num : array) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = start; i < nums.length; i++) {
            array.add(nums[i]);
            backtrack(nums, array, i, depth + 1, maxDepth);
            array.remove(array.size() - 1);
        }
    }
}