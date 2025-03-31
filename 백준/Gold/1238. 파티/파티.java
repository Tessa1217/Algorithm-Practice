import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Arrays;

public class Main {
    
    // 학생 수, 도로 수, 파티 마을 위치
    static int N, M, X;
    
    // 도로 정보 그래프
    static List<List<Road>> roads = new ArrayList<>();
    
    // 경로 저장 배열
    static int[] route;
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        
        for (int i = 0; i <= N; i++) {
            roads.add(new ArrayList<>());
        }
        
        for (int i = 0; i < M; i++) {
            StringTokenizer ster = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(ster.nextToken());
            int end = Integer.parseInt(ster.nextToken());
            int duration = Integer.parseInt(ster.nextToken());
            roads.get(start).add(new Road(end, duration));
        }
        
        int maxRoute = 0;
        for (int i = 1; i <= N; i++) {
            maxRoute = Math.max(goToParty(i), maxRoute);
        }
        
        System.out.println(maxRoute);
        
    }
    
    private static int goToParty(int start) {
        
        // 파티 열리는 마을과 사는 마일이 동일할 경우
        if (start == X) {
            return 0;
        }
        
        int routeCnt = 0;
        
        
        routeCnt += dijkstra(start, X);
        
        routeCnt += dijkstra(X, start);
        
        return routeCnt;        
        
    }
    
    private static int dijkstra(int start, int end) {
        route = new int[N + 1];
        Arrays.fill(route, Integer.MAX_VALUE);
        route[start] = 0;
        
        PriorityQueue<Road> queue = new PriorityQueue<Road>((r1, r2) -> r1.getDuration() - r2.getDuration());
        queue.offer(new Road(start, route[start]));
        
        while (!queue.isEmpty()) {
            Road currentRoad = queue.poll();
            if (route[currentRoad.getEnd()] > currentRoad.getDuration()) {
                continue;
            }
            List<Road> roadList = roads.get(currentRoad.getEnd());
            for (Road road : roadList) {
                if (route[road.getEnd()] > road.getDuration() + currentRoad.getDuration()) {
                    route[road.getEnd()] = road.getDuration() + currentRoad.getDuration();
                    queue.offer(new Road(road.getEnd(), route[road.getEnd()]));
                }
            }
        }
        
        return route[end];
    }
}

class Road {
    
    private int end;
    
    private int duration;
    
    public Road(int end, int duration) {
        this.end = end;
        this.duration = duration;
    }
    
    public int getEnd() {
        return this.end;
    }
    
    public int getDuration() {
        return this.duration;
    }
    
}