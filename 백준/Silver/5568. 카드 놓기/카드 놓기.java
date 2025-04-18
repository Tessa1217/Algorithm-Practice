import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class Main {
    
    static List<String> cardComb = new ArrayList<>();
    
    static String[] comb;
    
    static boolean[] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        visited = new boolean[n];
        comb = new String[m];
        
        // 주어진 카드 숫자 배열
        String[] cards = new String[n];
        for (int i = 0; i < n; i++) {
            cards[i] = br.readLine();    
        }
        
        backtrack(cards, 0, m);
        
        System.out.println(cardComb.size());
    }
    
    private static void backtrack(String[] cards, int cnt, int maxCnt) {
        if (cnt == maxCnt) {            
            String cardNum = String.join("", comb);
            // 한 정수를 여러 조합으로 만들 수 있기 때문에 중복된 카드 숫자가 아닌 경우에만 추가
            if (cardComb.indexOf(cardNum) == -1) {
                cardComb.add(cardNum);
            }
            return;
        }
        for (int i = 0; i < cards.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                comb[cnt] = cards[i];
                backtrack(cards, cnt + 1, maxCnt);
                visited[i] = false;
            }
        }
    }
}