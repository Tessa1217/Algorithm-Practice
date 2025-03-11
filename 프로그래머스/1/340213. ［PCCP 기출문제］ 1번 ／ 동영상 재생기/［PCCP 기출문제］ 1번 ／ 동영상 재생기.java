class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        
        // 전체 비디오 시간
        int totalVideoTime = getSecondsFromStrMin(video_len);
        
        // 현재 지점 시간
        int positionTime = getSecondsFromStrMin(pos);
        
        // 오프닝 시작 시간
        int opStrTime = getSecondsFromStrMin(op_start);
        
        // 오프닝 종료 시간
        int opEndTime = getSecondsFromStrMin(op_end);      
        
        // 오프닝 여부 판별 및 오프닝일 경우 스킵한 시간
        positionTime = skipOpenning(positionTime, opStrTime, opEndTime);
        
        for (int i = 0; i < commands.length; i++) {
            if ("prev".equals(commands[i])) {
                positionTime = positionTime - 10 < 0 ? 0 : positionTime - 10;
            } else if ("next".equals(commands[i])) {               
                positionTime = positionTime + 10 > totalVideoTime ? totalVideoTime : positionTime + 10;
            }
            positionTime = skipOpenning(positionTime, opStrTime, opEndTime);
        }
        
        int min = positionTime / 60;
        int seconds = positionTime % 60;
        
        // 정답에 맞게 포맷
        String answer = addZeroToDigit(min) + ":" + addZeroToDigit(seconds);
        
        return answer;
    }
    
    // 오프닝 시간 여부 확인
    // 오프닝 구간일 경우에는 오프닝 끝시간으로 반환, 아닐 경우 현재 시간 반환
    private int skipOpenning(int positionTime, int opStrTime, int opEndTime) {
        if (positionTime >= opStrTime && positionTime <= opEndTime) {
            return opEndTime;
        }
        return positionTime;
    }
    
    // 문자열 시간에서 초로 변환
    private int getSecondsFromStrMin(String timeStr) {
        String[] timeArray = timeStr.split(":");
        return (Integer.parseInt(timeArray[0]) * 60) + Integer.parseInt(timeArray[1]);
    }
    
    // 숫자 포맷 맞추기
    private String addZeroToDigit(int number) {
        return String.format("%2s", number).replace(' ', '0');
    }
}