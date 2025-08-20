import java.util.Stack;
class Solution {
    public int solution(int[] order) {
        // 택배를 싣는 트럭
        int order_length = order.length;
        // 컨테이너 벨트에 놓인 순서대로 택배 상자 내릴 수 있음
        // 보조 컨테이너 벨트는 입구 외에 다른 면이 막혀 있어 맨 앞의 상자만 뺄 수 있음        
        Stack<Integer> sub_container = new Stack<>();
                    
        // [5, 4, 3, 2, 1] 일 때
        // 컨테이너 벨트에 순서대로 꺼내서 보조 컨테이너에 담기
        // [1, 2, 3, 4, 5] => [5, 4, 3, 2, 1]
        // 보조 컨테이너에서 꺼내서 실으면 전체 박스 5개를 다 실을 수 있음
            
        // [4, 3, 1, 2, 5]일 때
        // 컨테이너 벨트에서 순서대로 1, 2, 3을 꺼내서 보조 컨테이너에 담기
        // 보조 컨테이너에는 [3, 2, 1]이 보관된 상태
        // 박스 4를 컨테이너 벨트에서 꺼내서 싣고
        // 보조 컨테이너에스 박스 3을 꺼내서 싣기
        // 컨테이너 박스는 현재 박스 5만 남았고 다음으로 꺼내야 하는 박스 1은 보조 컨테이너에서 박스 2 다음에 있으므로
        // 더는 박스를 뺄 수 없으므로 박스 싣기 종료
        
        int order_idx = 0;
        
        for (int i = 1; i <= order_length; i++) {            
            if (i == order[order_idx]) {
                order_idx++;
            } else {
                sub_container.push(i);
            }            
            
            while (!sub_container.isEmpty() && sub_container.peek() == order[order_idx]) {                
                sub_container.pop();
                order_idx++;
            }
        }
         
                                    
        return order_idx;
    }
}