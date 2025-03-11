import java.util.Arrays;
import java.util.Comparator;
class Solution {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String word1, String word2) {
                char l1 = word1.charAt(n);
                char l2 = word2.charAt(n);
                // 인덱스 값이 같은 경우에는 문자열 비교
                if (l1 - l2 == 0) {
                    return word1.compareTo(word2);
                }
                return l1 - l2;
            }
        });
        return strings;
    }
}