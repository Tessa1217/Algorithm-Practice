import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.IntStream;

public class Main {
    
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        
        // 1 ~ N까지 숫자 배열 생성
        int[] nums = IntStream.rangeClosed(1, N)
                              .toArray();
        
        // 백트래킹 시작
        backtrack(nums, new ArrayList<>(), 0, M);
        
        System.out.println(sb.toString());
        
    }
    
    private static void backtrack(int[] nums, List<Integer> array, int depth, int maxDepth) {
        // M 길이만큼의 수열이 생성되었다면
        if (depth == maxDepth) {
            for (int num : array) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            array.add(nums[i]);
            backtrack(nums, array, depth + 1, maxDepth);
            array.remove(array.size() - 1);
        }
    }
}