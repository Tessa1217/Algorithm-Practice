import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Objects;

class Solution {

    static Map<Integer, List<RoutingNode>> routeMap = new HashMap<>();
    
    static int maxRouteLength = 0;
    
    public int solution(int[][] points, int[][] routes) {
        calcAllRobotsRoutes(points, routes);
        int answer = calcCollisionRate();
        return answer;
    }
    
    // 충돌 계산
    private static int calcCollisionRate() {
        
        int collisionCnt = 0;
        
        for (int i = 0; i < maxRouteLength; i++) {
            // 해당 초에 루트 별 로봇이 지나간 횟수 맵
            Map<RoutingNode, Integer> collisionMap = new HashMap<>();            
            for (List<RoutingNode> routes : routeMap.values()) {
                RoutingNode route = (routes.size() > i) ? routes.get(i) : null;
                if (route != null) {
                    collisionMap.put(route, collisionMap.getOrDefault(route, 0) + 1);
                }
            }
            
            // 1회 이상 지나간 (충돌난) 좌표 수 더하기
            collisionCnt += (int) collisionMap.values()
                .stream()
                .filter(x -> x > 1)
                .count();
        }
        
        return collisionCnt;
        
    }
    
    // 로봇들의 경로 리스트 계산
    private static void calcAllRobotsRoutes(int[][] points, int[][] routes) {
        // 로봇의 수
        int robotCnt = routes.length;
        
        for (int i = 0; i < robotCnt; i++) {
            List<RoutingNode> routeList = new ArrayList<>();
            int[] robotRoute = routes[i];
            for (int j = 0; j < robotRoute.length - 1; j++) {
                // 2, 3, 4, 5
                calcPointToPointRoutes(points[robotRoute[j] - 1], points[robotRoute[j + 1] - 1], routeList);
            }
            // 가장 큰 루트 길이
            routeMap.put(i, routeList);
            if (!routeList.isEmpty()) {
                maxRouteLength = (routeList.size() >= maxRouteLength) ? routeList.size() : maxRouteLength;
            }
        }
         
    }
    
    // 로봇이 시작점에서 끝점으로 향하는 경로 리스트 계산
    private static void calcPointToPointRoutes(int[] startPoint, int[] endPoint, List<RoutingNode> routes) {
        
        // 시작 r, c
        int r = startPoint[0];
        int c = startPoint[1];
        
        // 최초 시작 포인트일 경우 (시작점) routes 리스트에 현재 좌표 추가
        if (routes.isEmpty()) {
            routes.add(new RoutingNode(r, c));
        }
        
        // 포인트 이동 시 r 좌표가 변하는 이동을 c 좌표가 변하는 이동보다 먼저 계산
        while (r != endPoint[0]) {
            r += (r > endPoint[0]) ? -1 : 1;
            routes.add(new RoutingNode(r, c));
        }
        
        // c 좌표 이동 계산
        while (c != endPoint[1]) {
            c += (c > endPoint[1]) ? -1 : 1;
            routes.add(new RoutingNode(r, c));
        }
    }
    
    // 운송 경로 좌표
    static class RoutingNode {
        int r;
        int c;
        
        @Override
        public int hashCode() {
            return Objects.hash(r, c);
        }
        
        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof RoutingNode)) {
                return false;
            }
            RoutingNode node = (RoutingNode) o;
            if (node.r == this.r && node.c == this.c) {
                return true;
            }
            return false;
        }
        
        public RoutingNode(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}