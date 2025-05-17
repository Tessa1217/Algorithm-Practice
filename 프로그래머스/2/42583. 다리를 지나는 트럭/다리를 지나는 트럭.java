import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        
        int answer = 0;
        
        // 다리 위 트럭
        Queue<Integer> bridge = new LinkedList<>();
        // 다리 위 무게
        int bridge_weight = 0;
        
        for (int i = 0; i < truck_weights.length; i++) {        
            int truck_weight = truck_weights[i];
            while (true) {
                if (bridge.isEmpty()) {
                    bridge.offer(truck_weight);
                    bridge_weight += truck_weight;
                    answer += 1;
                    break;
                } else if (bridge.size() == bridge_length) {
                    bridge_weight -= bridge.poll();
                } else {
                    if (bridge_weight + truck_weight > weight) {
                        bridge.add(0);
                        answer++;
                    } else {
                        bridge.offer(truck_weight);
                        bridge_weight += truck_weight;
                        answer++;
                        break;
                    }
                }                
            }              
        }
        
        answer += bridge_length;
        
        return answer;
    }
}