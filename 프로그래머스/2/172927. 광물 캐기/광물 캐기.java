import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        
        int answer = 0;    
        
        // 총 곡괭이의 개수
        int totalPicks = picks[0] + picks[1] + picks[2];
        
        // 곡괭이별 캘 수 있는 광물 개수 (한 곡괭이당 광물 종류에 상관없이 5개씩 캘 수 있음)
        int[] pickCntArr = Arrays.stream(picks).map(i -> i * 5).toArray();
        
        int length = minerals.length;
        
        // 피로도 배열
        int[][] mineralHp = new int[totalPicks][6];
        
        // 5개씩 연속해서 캘 수 있으므로 5개씩 그룹지어서 누적 계산
        for (int i = 0; i < Math.min(totalPicks * 5, length); i += 5) {
            // 그룹의 누적 합
            int sum = 0;            
            for (int j = i; j < Math.min(i + 5, length); j++) {
                // 각 그룹의 요소별 피로도 (최악의 피로도를 자랑하는 돌 곡괭이를 기준으로 계산)
                int hp = 0;
                if ("diamond".equals(minerals[j])) { // 다이아몬드 25
                    hp = 25;
                } else if ("iron".equals(minerals[j])) { // 철 25
                    hp = 5;
                } else if ("stone".equals(minerals[j])) { // 돌 1
                    hp = 1;
                }
                mineralHp[i / 5][j % 5 + 1] = hp;
                sum += hp;
            }
            // 그룹의 누적 피로도 계산
            mineralHp[i / 5][0] = sum;
        }
        
        // 누적 피로도 내림차순으로 정렬
        Arrays.sort(mineralHp, (o1, o2) -> o2[0] - o1[0]);
        
        // 현재 곡괭이 인덱스
        int pickIdx = 0;    
        
        for (int i = 0; i < totalPicks; i++) {
            
            int[] mineralGroup = mineralHp[i];
            
            if (pickIdx == picks.length) {
                break;
            }
            
            // 다음 0이 아닌 곡괭이 인덱스 찾기
            while (pickCntArr[pickIdx] == 0) {
                pickIdx++;
            }
            // 다음 곡괭이 카운트가 0일 경우에 대한 반례 존재 (case 3)
            // if (pickCntArr[pickIdx] == 0) {
            //     pickIdx++;
            // }     
            
            // 현재 곡괭이로 광물 캘 시 피로도 계산 누적
            for (int j = 1; j < 6; j++) {          
                if (pickIdx == 0) {
                    // 실수형으로 나누는 이유는 5 / 25는 0이기 때문에 1로 카운트 위해서 실수로 나눈 뒤 ceil
                    answer += (int) Math.ceil(mineralGroup[j] / 25.0);
                } else if (pickIdx == 1) {
                    answer += (int) Math.ceil(mineralGroup[j] / 5.0);
                } else if (pickIdx == 2) {
                    answer += mineralGroup[j];
                }
                // 사용 곡괭이 카운트 --
                pickCntArr[pickIdx]--;
            }
        }
        
        return answer;
    }
}