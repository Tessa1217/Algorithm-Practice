def solution(m, musicinfos):
    
    answer = ''    
    max_duration = 0
    min_start_time = 60 * 24
    
    parsed_melody = parse_melody(m)
    
    for music in musicinfos:
        
        # 음악 정보
        start_time, end_time, title, melody = music.split(",")
        
        # 총 걸린 시간
        duration = parse_time_str(end_time) - parse_time_str(start_time)
        
        # 현재 음악의 멜로디 파싱
        parsed_music_melody = parse_melody(melody)
                                
        divide = duration // len(parsed_music_melody)
        left = duration % len(parsed_music_melody)
        
        # 현재 멜로디를 재생 시간에 맞춰서 실제 재생된 멜로디에 맞게 변경
        full_melody = (parsed_music_melody * divide) + parsed_music_melody[:left]
        
        if parsed_melody in full_melody:
            # 조건 일치하는 음악이 여러 개일 때
            # 재생 시간이 가장 긴 음악을 반환
            # 재생 시간 같을 경우는 먼저 입력된 음악 제목 반환
            if max_duration < duration:                
                answer = title
                max_duration = duration
    
    # 조건이 일치하는 음악이 없을 때에는 (None)을 반환한다
    if answer == '':
        return "(None)"
    
    return answer


def parse_time_str(time):
    hour, min = time.split(":")
    return int(hour) * 60 + int(min)
    

def parse_melody(melody):
    # # 한 글자로 치환 후 반환 (B#도 기재 필요)
    parsed_melody = melody.replace("C#", "H").replace("D#", "I").replace("F#", "J").replace("G#", "K").replace("A#", "L").replace("B#", "M")    
    return parsed_melody
        
        
        
    