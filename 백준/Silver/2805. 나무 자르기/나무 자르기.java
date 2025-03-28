import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    
    static int[] trees;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 나무의 수
        int N = Integer.parseInt(st.nextToken());
        // 가져가려는 길이
        int M = Integer.parseInt(st.nextToken());
        // 나무 배열 초기화
        trees = new int[N];
        
        st = new StringTokenizer(br.readLine());
        long max = 0;
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, trees[i]);
        }
        
        long height = binaryUpperBound(0, max + 1, M);
        System.out.println(height - 1);
    }
    
    private static long binaryUpperBound(long start, long end, long M) {
        while (start < end) {
            long mid = (start + end) / 2;
            long treeLength = 0;
            for (int i = 0; i < trees.length; i++) {
                long current = trees[i] - mid > 0 ? trees[i] - mid : 0;
                treeLength += current;
            }
            
            if (treeLength < M) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}