import java.util.Queue;
import java.util.LinkedList;

class Solution {
    boolean solution(String s) {
        
        boolean answer = true;
        
        Queue<Character> parenthesis = new LinkedList<>();
        
        char[] pArray = s.toCharArray();
        
        for (char p : pArray) {
            if (p == ')' && (!parenthesis.isEmpty() && parenthesis.peek() == '(')) {
                parenthesis.poll();
                continue;
            }
            parenthesis.add(p);
        }

        return parenthesis.isEmpty();
    }
}