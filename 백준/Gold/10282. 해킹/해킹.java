import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Arrays;

public class Main {
    
    // 테스트 케이스 수
    static int T;
    
    // 컴퓨터 개수, 의존성 개수, 해킹당한 컴퓨터
    static int n, d, c;
    
    // 컴퓨터 그래프
    static List<List<Computer>> computers;
    
    static int max = Integer.MAX_VALUE;
    
    // 감염 시간 배열
    static int[] time;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        T = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        
        for (int t = 0; t < T; t++) {
            computers = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            for (int i = 0; i <= n; i++) {
                computers.add(new ArrayList<>());
            }
            for (int i = 0; i < d; i++) {
                StringTokenizer ster = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(ster.nextToken());
                int b = Integer.parseInt(ster.nextToken());
                int s = Integer.parseInt(ster.nextToken());       
                // 주의사항: a가 b에 의존한다면 b가 감염될 경우 a도 감염 
                // (양방향으로 연결해서 자꾸 틀렸다...)
                computers.get(b).add(new Computer(a, s));
            }
            
            // 감염 시간 배열
            time = new int[n + 1];
            Arrays.fill(time, max);
            time[c] = 0;            
            
            int[] hacked = dijkstra();
            sb.append(hacked[0])
              .append(" ")
              .append(hacked[1])
              .append("\n");
        }
        
        System.out.println(sb);
        
    }
    
    private static int[] dijkstra() {
        
        int[] hacked = new int[2];
        
        PriorityQueue<Computer> queue = new PriorityQueue<Computer>((c1, c2) -> c1.getS() - c2.getS());
        queue.offer(new Computer(c, time[c]));
        
        while (!queue.isEmpty()) {
            Computer current = queue.poll();
            if (time[current.getB()] > current.getS()) {
                continue;
            }
            List<Computer> computerList = computers.get(current.getB());
            for (Computer computer : computerList) {
                if (time[computer.getB()] > computer.getS() + current.getS()) {
                    time[computer.getB()] = computer.getS() + current.getS();
                    queue.offer(new Computer(computer.getB(), time[computer.getB()]));
                }
            }
        }
        
        for (int i = 1; i <= n; i++) {
            if (time[i] == max) {
                continue;
            }
            hacked[0] += 1;
            hacked[1] = Math.max(hacked[1], time[i]);
        }
        
        return hacked;
        
    }
}

class Computer {
    
    // 컴퓨터 번호
    private int b;
    
    // 감염 초
    private int s;
    
    public Computer(int b, int s) {
        this.b = b;
        this.s = s;
    }
    
    public int getB() {
        return this.b;
    }
    
    public int getS() {
        return this.s;
    }
    
}