import java.util.Set;
import java.util.HashSet;

class Solution {
    
    // 숫자 배열
    static int[] arr;
    
    // 문자열 최대 길이
    static int max;
    
    // 방문 배열
    static boolean[] visited;
    
    // 숫자 세트
    static Set<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        int answer = 0;
        max = numbers.length();
        arr = new int[max];
        visited = new boolean[max];
        
        for (int i = 0; i < max; i++) {
            arr[i] = Integer.parseInt(numbers.substring(i, i + 1));
        }
        
        for (int i = 0; i < max; i++) {
            makeNumber(0, i + 1, "");
        }
        
        return set.size();
    }
    
    // 종이에 적힌 숫자로 숫자 만들기
    private void makeNumber(int depth, int maxDepth, String num) {        
        if (depth == maxDepth) {
            if (isPrime(Integer.parseInt(num))) {
               set.add(Integer.parseInt(num));
            } 
            return;
        }
        for (int i = 0; i < max; i++) {
            if (visited[i]) {
                continue;
            }
            String newNum = num + String.valueOf(arr[i]);
            visited[i] = true;
            makeNumber(depth + 1, maxDepth, newNum);
            visited[i] = false;   
        }
    } 
    
    
    // 소수 판별하기
    private boolean isPrime(int num) {        
        if (num < 2) {
            return false;
        }
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
    
}