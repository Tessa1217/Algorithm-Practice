import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.stream.IntStream;

public class Main {
    
    static boolean[] visited;
    
    static String[] number;
    
    static String min = String.valueOf(Long.MAX_VALUE);
    
    static String max = String.valueOf(Long.MIN_VALUE);
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        char[] equality = br.readLine().replaceAll(" ", "").toCharArray();        
        number = new String[equality.length + 1];
        int[] nums = IntStream.rangeClosed(0, 9).toArray();
        visited = new boolean[nums.length];
        
        for (int i = 0; i < nums.length; i++) {
            backtrack(i, 0, equality.length, nums, equality);
        }
        
        System.out.println(max);
        System.out.println(min);
        
    }
    
    private static void backtrack(int start, int depth, int maxDepth, int[] nums, char[] equality) {
        int startNum = nums[start];
        number[depth] = String.valueOf(startNum);  
        // 최댓값, 최솟값 문자열
        if (depth == maxDepth) {
            String newNum = String.join("", number);
            min = Long.parseLong(newNum) < Long.parseLong(min) ? newNum : min;
            max = Long.parseLong(newNum) > Long.parseLong(max) ? newNum : max;
            return;
        }
        visited[startNum] = true;
        for (int i = 0; i < nums.length; i++) {
            int nextNum = nums[i];
            if (!visited[nextNum]) {
                visited[nextNum] = true;
                if (equality[depth] == '<' && startNum < nextNum) {
                    backtrack(i, depth + 1, maxDepth, nums, equality);
                } else if (equality[depth] == '>' && startNum > nextNum) {
                    backtrack(i, depth + 1, maxDepth, nums, equality);
                }
                visited[nextNum] = false;
            }
        }
        visited[startNum] = false;
    }
}