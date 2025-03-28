import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    
    // 숫자 배열
    static int[] numArr;
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");
        numArr = new int[N];
        for (int i = 0; i < N; i++) {
            numArr[i] = Integer.parseInt(arr[i]);
        }
        // 탐색할 배열 오름차순으로 정렬
        Arrays.sort(numArr);        
        
        int M = Integer.parseInt(br.readLine());
        String[] arrM = br.readLine().split(" ");
        
        br.close();
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(arrM[i]);
            int search = binarySearch(0, N - 1, target);
            if (search == -1) {
                sb.append("0").append("\n");
            } else {
                sb.append("1").append("\n");
            }
        }
        
        System.out.println(sb);
        
    }
    
    // 이진 탐색
    private static int binarySearch(int start, int end, int target) {
        int mid;
        if (start <= end) {
            mid = (start + end) / 2;
            if (numArr[mid] == target) {
                return mid;
            } else if (numArr[mid] < target) {
                return binarySearch(mid + 1, end, target);
            } else if (numArr[mid] > target) {
                return binarySearch(start, mid - 1, target);
            }
        }
        return -1;
    }
}