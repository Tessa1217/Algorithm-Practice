import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 0;
        while (n > 0) {
            // 순간이동 가능한 위치였을 경우
            if (n % 2 == 0) {
                n /= 2;
            } else {
                // 순간 이동 가능한 위치로 만들기 위해 점프
                n -= 1; 
                ans++;
            }
        }
        return ans;
    }
}