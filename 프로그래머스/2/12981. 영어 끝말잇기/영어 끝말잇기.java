import java.util.List;
import java.util.Arrays;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[]{0, 0};
        
        List<String> word = Arrays.asList(words);
        
        for (int i = 1; i < words.length; i++) {
            if (isWordNotValid(words[i - 1], words[i]) || isDuplicateWord(word, words[i], i) || isWordShort(words[i])) {
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                break;
            }    
        }
        
        return answer;
    }
    
    // 한 글자로 이루어진 단어
    private boolean isWordShort(String currentWord) {
        return currentWord.length() < 2;
    }
    
    // 끝말잇기를 하고 있지 않은 단어
    private boolean isWordNotValid(String beforeWord, String currentWord) {
        return beforeWord.charAt(beforeWord.length() - 1) != currentWord.charAt(0);
    }
    
    // 중복 단어
    private boolean isDuplicateWord(List<String> word, String currentWord, int currentIdx) {
        return word.indexOf(currentWord) != currentIdx;
    }
}