import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        
        int idx = 0;
        
        // 가장 무거운 사람과 가장 가벼운 사람의 무게의 합이 무게 제한을 넘는지 검사
        for (int i = people.length - 1; i >= idx; i--) {
            if (people[i] + people[idx] <= limit) {
                answer++;
                idx++;
            } else {
                answer++;
            }
        }
        return answer;
    }
}