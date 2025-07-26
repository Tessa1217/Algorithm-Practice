import java.util.Queue;
import java.util.ArrayDeque;

class Solution {
    // 선행으로 배워야 하는 스킬이 아니라면 skill tree 무시 가능
    // 선행으로 배워야 하는 스킬이 있는 경우라면 반드시 이전 스킬을 배워야 스킵 가능
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for (String skill_tree : skill_trees) {
            answer += check_skill_valid(skill, skill_tree);
        }
        return answer;
    }
    
    // 스킬을 배울 수 있는 지 여부를 확인
    private int check_skill_valid(String skill, String skill_tree) {
        int skill_idx = 0;        
        for (Character c : skill_tree.toCharArray()) {            
            if (skill.indexOf(c) == -1) {
                continue;
            }           
            if (skill.charAt(skill_idx) != c) {
                return 0;
            }
            skill_idx++;
        }        
        return 1;        
    }
}