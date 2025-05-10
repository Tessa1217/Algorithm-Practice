import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

class Solution {
    
    int[] dx = {1, -1, 0, 0};
    
    int[] dy = {0, 0, 1, -1};
    
    public int[] solution(String[] maps) {
        
        List<Integer> answer = new ArrayList<>();
        
        // 맵 배열 초기화
        char[][] map = new char[maps.length][maps[0].length()];
        for (int i = 0; i < maps.length; i++) {
            map[i] = maps[i].toCharArray();
        }
        
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                // 영역의 값이 숫자로 이루어져 있다면
                if (Character.isDigit(map[i][j])) {
                    // BFS 
                    bfs(i, j, map, answer);
                }
            }
        }
        
        // 섬이 없다면 (숫자로 이뤄진 영역 X)
        if (answer.size() == 0) {
            return new int[]{-1};
        }
        
        // 오름차순 정렬
        return answer.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
    
    // BFS
    private void bfs(int startX, int startY, char[][] map, List<Integer> answer) {
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX, startY});
        int cnt = Character.getNumericValue(map[startX][startY]);
        // 영역 서치했으므로 X로 표시
        map[startX][startY] = 'X';
       
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            for (int i = 0; i < 4; i++) {
                int newX = current[0] + dx[i];
                int newY = current[1] + dy[i];
                if (newX >= 0 && newX < map.length &&
                    newY >= 0 && newY < map[0].length
                   ) {
                    if (Character.isDigit(map[newX][newY])) {
                        queue.offer(new int[]{newX, newY});
                        cnt += Character.getNumericValue(map[newX][newY]);
                        map[newX][newY] = 'X';
                    }
                }
            }
        }
        
        answer.add(cnt);
    }
}