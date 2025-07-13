import java.util.Map;
import java.util.Set;
import java.util.HashSet;

// 게임 캐릭터의 4가지 명령어
// U : (1, 0), D : (-1, 0), R : (0, 1), L : (0, -1)

// 명령어 ULURRDLLU에 대한 이동
// #1. 0, 0 -> 1, 0 (U)
// #2. 1, 0 -> 1, -1 (L)
// #3. 1, -1 -> 2, -1 (U)
// #4. 2, -1 -> 2, 0 (R)
// #5. 2, 0 -> 2, 1 (R)
// #6. 2, 1 -> 1, 1 (D)
// #7. 1, 1 -> 1, 0 (L)
// #8. 1, 0 -> 1, -1 (L) => 2번째 명령어와 동일
// #9. 1, -1 -> 2, -1 (U) => 3번째 명령어와 동일
class Solution {
    
    private Map<Character, int[]> order_map = Map.ofEntries(
        Map.entry('U', new int[]{1, 0}),
        Map.entry('D', new int[]{-1, 0}),
        Map.entry('R', new int[]{0, 1}),
        Map.entry('L', new int[]{0, -1})
    );
    
    public int solution(String dirs) {
        
        // 로봇이 처음 걸어본 길의 길이
        int answer = 0;
        
        // 로봇의 최초 좌표
        int rx = 0;
        int ry = 0;        
        
        // 로봇의 좌표 배열 저장 Set
        Set<String> robot_route = new HashSet<>();
        
        for (Character d : dirs.toCharArray()) {
            
            int[] direction = order_map.get(d);
            int nx = rx + direction[0];
            int ny = ry + direction[1];
            
            // 범위 아니면 명령어 무시
            if (!is_robot_in_range(nx, ny)) {
                continue;
            }
            
            // 이동 전 위치 -> 이동 후 위치를 String 형태로 저장 (ex) 0010
            // 00 -> 10간 거랑 10 -> 00 간 거랑 동일하게 본다면...?            
            robot_route.add(map_route(rx, ry, nx, ny));
            robot_route.add(map_route(nx, ny, rx, ry));
            
            rx = nx;
            ry = ny;            
            
        }
        
        return (int) robot_route.size() / 2;
    }
    
    private boolean is_robot_in_range(int rx, int ry) {
        return rx >= -5 && rx <= 5 && ry >= -5 && ry <= 5;
    }
    
    private String map_route(int rx, int ry, int nx, int ny) {
        StringBuilder sb = new StringBuilder();
        sb.append(rx).append(ry).append(nx).append(ny);
        return sb.toString();
    }
    
    
}