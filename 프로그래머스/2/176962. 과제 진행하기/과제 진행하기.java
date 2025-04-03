import java.util.Stack;
import java.util.PriorityQueue;
import java.util.Comparator;

class Solution {
    
    public String[] solution(String[][] plans) {
        
        String[] answer = new String[plans.length];
        
        // 과제 진행 우선순위 큐
        PriorityQueue<Homework> queue = new PriorityQueue<>(Comparator.comparingInt(h -> h.start));        
        for (int i = 0; i < plans.length; i++) {            
            queue.offer(convertArrToHomework(plans[i]));            
        }

        int idx = 0;
        Stack<Homework> leftHomework = new Stack<>();
        
        while (!queue.isEmpty()) {
            Homework current = queue.poll();
            // 남은 과제가 없을 경우
            if (queue.peek() == null) {
                answer[idx++] = current.name;
                break;
            }
            // 종료 시간
            int endTime = current.start + current.playtime;
            // 과제 종료 시간이 다음 과제 시작시간보다 크다면            
            if (queue.peek().start < endTime) {
                int leftPlaytime = endTime - queue.peek().start;
                // 지연 과제 스택에 push                
                leftHomework.push(new Homework(current.name, current.start, leftPlaytime));
            } else {
                answer[idx++] = current.name;                
                // 과제 종료 후에도 시간이 남는다면
                if (queue.peek().start > endTime && !leftHomework.isEmpty()) {
                    // 남는 시간
                    int leftTime = queue.peek().start - endTime;
                    while (leftHomework.size() > 0 && leftTime > 0) {
                        Homework left = leftHomework.pop();
                        // 남는 시간 안에 과제를 종료할 수 있다면
                        if (leftTime - left.playtime >= 0) {
                            leftTime -= left.playtime;
                            answer[idx++] = left.name;
                        } else {
                            left.playtime -= leftTime;                                
                            leftHomework.push(left);
                            leftTime = 0;
                        }
                    }
                }
            }            
        }
        
        // 남은 숙제 순차적으로 꺼내서 종료 처리
        while (!leftHomework.isEmpty()) {
            answer[idx++] = leftHomework.pop().name;           
        }

        return answer;
    }
    
    // 배열을 Homework로 변환
    private static Homework convertArrToHomework(String[] plan) {
        int time = convertTimeStrToInt(plan[1]);
        int playtime = Integer.parseInt(plan[2]);
        return new Homework(plan[0], time, playtime);
    }    
    
    // 시간 문자열 정수로 변환
    private static int convertTimeStrToInt(String time) {        
        String[] timeArr = time.split(":");
        return (Integer.parseInt(timeArr[0]) * 60) + Integer.parseInt(timeArr[1]);
    }
}

class Homework {
    
    // 과제 명
    String name;
    
    // 과제 시작시간
    int start;
    
    // 과제 소요시간
    int playtime;
    
    public Homework(String name, int start, int playtime) {
        this.name = name;
        this.start = start;
        this.playtime = playtime;
    }
    
}
