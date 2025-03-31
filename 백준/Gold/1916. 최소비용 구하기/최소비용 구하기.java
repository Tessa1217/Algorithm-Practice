import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main {
    
    // 도시의 개수, 버스의 개수, 시작 도시, 종료 도시
    static int N, M, K, E;
    
    // 경로
    static List<List<Bus>> routes = new ArrayList<>();
    
    // 도시별 도착 비용
    static int[] fees;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        
        
        for (int i = 0; i <= N; i++) {
            routes.add(new ArrayList<>());
        }
        
        fees = new int[N + 1];
        Arrays.fill(fees, Integer.MAX_VALUE);
        
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int fee = Integer.parseInt(st.nextToken());
            
            routes.get(s).add(new Bus(e, fee));
            
        }
        
        // 시작, 종료지점 세팅
        StringTokenizer ster = new StringTokenizer(br.readLine());
        K = Integer.parseInt(ster.nextToken());
        fees[K] = 0;
        E = Integer.parseInt(ster.nextToken());
        
        dijkstra();
        
        System.out.println(fees[E]);
        
    }
    
    // 다익스트라로 해당 도시로 갈 때 최소 비용 구하기
    private static void dijkstra() {
        PriorityQueue<Bus> queue = new PriorityQueue<Bus>((b1, b2) -> b1.getFee() - b2.getFee());
        queue.offer(new Bus(K, fees[K]));
        
        while (!queue.isEmpty()) {
            Bus currentBus = queue.poll();
            if (fees[currentBus.getCity()] < currentBus.getFee()) {
                continue;
            }
            List<Bus> busList = routes.get(currentBus.getCity());
            for (Bus bus : busList) {
                if (fees[bus.getCity()] > currentBus.getFee() + bus.getFee()) {
                    fees[bus.getCity()] = currentBus.getFee() + bus.getFee();
                    queue.offer(new Bus(bus.getCity(), fees[bus.getCity()]));
                }
            }
        }
    }
}

class Bus {
    
    private int city;
    
    private int fee;
    
    public Bus(int city, int fee) {
        this.city = city;
        this.fee = fee;
    }
    
    public int getCity() {
        return this.city;
    }
    
    public int getFee() {
        return this.fee;
    }
    
}