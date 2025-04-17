class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        char[] letters = s.toCharArray();        
        for (int i = 0; i < letters.length; i++) {
            int idx = 1;
            char newLetter = letters[i];
            while (idx <= index) {
                newLetter = (char) (newLetter + 1);
                if (newLetter > 'z') {
                    newLetter = (char) (newLetter % 'z' + 'a' - 1);
                }
                if (skip.indexOf(newLetter) == -1) {
                    idx++;
                }          
            }            
            letters[i] = newLetter;
        }
        return String.valueOf(letters);
    }
}