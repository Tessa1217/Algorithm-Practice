import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public List<Integer> solution(String[] genres, int[] plays) {
        
        // 앨범 배열
        List<Integer> album = new ArrayList<>();
        
        // 장르에 대한 정보 세팅
        Map<String, GenreInfo> genreInfo = new HashMap<>();        
        for (int i = 0; i < genres.length; i++) {
            GenreInfo genre = genreInfo.getOrDefault(genres[i], new GenreInfo());
            // 재생 시간 누적 더하기
            genre.addPlayCnt(plays[i]);
            // 장르에 속한 노래 정보 더하기
            genre.addSong(new int[]{i, plays[i]});
            genreInfo.put(genres[i], genre);
        }
        
        List<String> keySets = new ArrayList(genreInfo.keySet());
        // 재생 시간 기준 내림차순 정렬
        Collections.sort(keySets, (s1, s2) -> {
            return genreInfo.get(s2).getPlayCnt() - genreInfo.get(s1).getPlayCnt();
        });
            
        for (String key : keySets) {
            GenreInfo genre = genreInfo.get(key);
            List<int[]> songList = genre.getSongList();
            // 1곡인 경우에는 하나의 곡만 바로 앨범에 삽입
            if (songList.size() == 1) {
                album.add(songList.get(0)[0]);
            } else {
                // 노래의 재생횟수 기준으로 내림차순 정렬
                Collections.sort(songList, (s1, s2) -> s2[1] - s1[1]);
                // 최대 재생횟수 가진 2곡만 삽입
                for (int i = 0; i < 2; i++) {
                    album.add(songList.get(i)[0]);
                }
            }
        }
        return album;
    }
}

class GenreInfo {
    
    // 재생 시간
    private int playCnt = 0;
    
    // 노래 목록
    private List<int[]> song = new ArrayList<>();
    
    public GenreInfo() {
        
    }
    
    // 재생 시간 가져오기
    public int getPlayCnt () {
        return this.playCnt;
    }
    
    // 노래 목록 가져오기
    public List<int[]> getSongList () {
        return new ArrayList(this.song);
    }
    
    // 재생 시간 더하기
    public void addPlayCnt (int cnt) {
        playCnt += cnt;
    }
    
    // 노래 추가하기
    public void addSong (int[] newSong) {
        song.add(newSong);
    }
    
}