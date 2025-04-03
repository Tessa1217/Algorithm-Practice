import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;

class Solution {
    public String[] solution(String[][] plans) {
        
        String[] answer = new String[plans.length];
        
        // 시작 시간 기준으로 오름차순 정렬 
        Arrays.sort(plans, (p1, p2) -> p1[1].compareTo(p2[1]));
        
        // 과제 진행 큐
        int maxTime = 0; // 제일 늦게 끝나는 과제 시간
        Queue<Homework> queue = new LinkedList<>();        
        for (int i = 0; i < plans.length; i++) {
            int time = convertTimeStrToInt(plans[i][1]);
            queue.offer(new Homework(plans[i][0], time, Integer.parseInt(plans[i][2])));            
            maxTime = Math.max(maxTime, time);
        }
        
        int idx = 0;
        Stack<Homework> leftHomework = new Stack<>();
        while (idx < plans.length) {
            Homework current = queue.poll();    
            // 과제 진행 한바뀌 끝났다면
            if (current.start == maxTime) {                
                answer[idx++] = current.name;                
                while (!leftHomework.isEmpty()) {
                    answer[idx++] = leftHomework.pop().name;
                }
            }
            if (queue.peek() != null) {
                int endTime = current.start + current.playtime;
                // 과제 종료 시간이 다음 과제 시작시간보다 크다면
                if (queue.peek().start < endTime) {
                    int leftPlaytime = endTime - queue.peek().start;
                    System.out.println(leftPlaytime);
                    // 지연 과제 스택에 push
                    leftHomework.push(new Homework(current.name, current.start, leftPlaytime));
                } else {
                    answer[idx] = current.name;
                    idx++;
                    // 과제 종료 후에도 시간이 남는다면
                    if (queue.peek().start > endTime && !leftHomework.isEmpty()) {
                        int leftTime = queue.peek().start - endTime;
                        while (leftHomework.size() > 0 && leftTime > 0) {
                            Homework left = leftHomework.pop();
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
        }
        
        return answer;
    }
    
    private static int convertTimeStrToInt(String time) {        
        String[] timeArr = time.split(":");
        return (Integer.parseInt(timeArr[0]) * 60) + Integer.parseInt(timeArr[1]);
    }
}

class Homework {
    
    String name;
    
    int start;
    
    int playtime;
    
    
    public Homework(String name, int start, int playtime) {
        this.name = name;
        this.start = start;
        this.playtime = playtime;
    }
    
    @Override
    public String toString() {
        return String.format("%s 과제는 %d 시간에 시작하며 %d분 걸린다.", this.name, this.start, this.playtime);
    }
}