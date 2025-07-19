import java.util.Map;
import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;
class Solution {
    /** 
    * 오픈 채팅방의 규칙
    * 1. 채팅방에 들어왔을 경우 [닉네임]님이 들어왔습니다.
    * 2. 채팅방에서 나갔을 경우 [닉네임]님이 나갔습니다.
    * 3. 닉네임을 변경한 채로 기존 채팅방에 돌아왔을 경우 [닉네임]님이 들어왔습니다/나갔습니다
    * 둘다 변경된 닉네임으로 교채
    * 4. 채팅방에서 닉네임을 교채한 경우에는 [닉네임]님이 들어왔습니다가 변경된 닉네임으로 교체
    * 풀이에 대한 흐름 진행:
    * record에 uid가 별도로 있기 때문에 uid 기준으로 이름을 Map에 담고 변경 작업을 거침
    * Enter, Leave에 대한 큐 생성
    * 해당 큐를 돌면서 최종 메시지 생성
    */
    public String[] solution(String[] record) {
        
        // 채팅창을 사용한 유저 아이디 맵
        Map<String, String> nameMap = new HashMap<>();
        // 채팅방 큐
        Queue<String> chatRoom = new LinkedList<>();
        // 채팅방 메시지를 보여줘야 하는 수 카운트
        int showCommandCnt = 0;        
        
        for (String r : record) {
            String[] recordInfo = r.split(" ");
            // Leave, Enter는 채팅창에 표시되므로 uId와 함께 큐에 삽입
            if ("Leave".equals(recordInfo[0]) || "Enter".equals(recordInfo[0])) {
                chatRoom.offer(recordInfo[0] + " " + recordInfo[1]);
                showCommandCnt++;
                if ("Leave".equals(recordInfo[0])) {
                    continue;
                }
            }
            
            // 이름을 이름 맵에 정의
            nameMap.put(recordInfo[1], recordInfo[2]);                      
        }
        
        String[] answer = new String[showCommandCnt];
        int idx = 0;
        
        while (!chatRoom.isEmpty()) {
            String[] cur_command = chatRoom.poll().split(" ");            
            answer[idx++] = nameMap.get(cur_command[1]) + generateCommandLine(cur_command[0]);
        }
        
        
        return answer;
    }
    
    // command에 따른 채팅방 표시 메세지 추출
    private String generateCommandLine(String command) {
        if ("Enter".equals(command)) {
            return "님이 들어왔습니다.";
        } else if ("Leave".equals(command)) {
            return "님이 나갔습니다.";
        }
        return "";
    }
}