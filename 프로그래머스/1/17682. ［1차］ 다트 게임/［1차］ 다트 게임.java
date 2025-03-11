import java.util.List;
import java.util.ArrayList;

class Solution {
    public int solution(String dartResult) {
        
        int answer = 0;
        
        String[] dartArr = dartResult.replaceAll("10", "N")
                                     .split("");
        
        List<Integer> scoreList = new ArrayList<>();
        
        int idx = -1;
        
        for (String dart : dartArr) {
            int currentNumber = parseNumber(dart);
            if (currentNumber >= 0) {
                scoreList.add(currentNumber);
                idx++;
                continue;
            }
            
            int areaBuff = computeAreaBuff(dart);
            if (areaBuff > 0) {
                scoreList.set(idx, (int) Math.pow(scoreList.get(idx), areaBuff));    
                continue;
            } 
            
            int awardBuff = computeAwardBuff(dart);
            if (awardBuff != 0) {
                scoreList.set(idx, scoreList.get(idx) * awardBuff);
                if (idx > 0 && awardBuff == 2) {
                    scoreList.set(idx - 1, scoreList.get(idx - 1) * awardBuff);    
                }                
            }                        
        }
        
        
        return scoreList.stream().reduce(0, Integer::sum);
    }
    
    private int computeAwardBuff(String str) {
        if ("*".equals(str)) {
            return 2;
        } else if ("#".equals(str)) {
            return -1;
        }
        return 0;
    }
    
    private int computeAreaBuff(String str) {
        if ("S".equals(str)) {
            return 1;
        } else if ("D".equals(str)) {
            return 2;
        } else if ("T".equals(str)) {
            return 3;
        }
        return 0;
    } 
    
    private boolean isNumeric(String str) {
        try {
            int number = Integer.parseInt(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
    
    private int parseNumber(String str) {
        if (str == null) {
            return -1;
        }
        if ("N".equals(str)) {
            return 10;
        }
        if (isNumeric(str)) {
            return Integer.parseInt(str);
        }
        return -1;        
    }
}