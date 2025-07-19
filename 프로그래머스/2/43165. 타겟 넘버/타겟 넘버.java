class Solution {
    
    int cnt = 0;
    
    public int solution(int[] numbers, int target) {
        dfs(numbers, 0, 0, target);
        return cnt;
    }
    
    // 재귀로 각 자리수에 대해 더하거나 뺌
    private void dfs(int[] numbers, int cur_idx, int cur_num, int target) {
        if (cur_idx == numbers.length) {
            if (cur_num == target) {
                cnt++;
            }
            return;
        }
        dfs(numbers, cur_idx + 1, cur_num + numbers[cur_idx], target);
        dfs(numbers, cur_idx + 1, cur_num - numbers[cur_idx], target);
    }
}