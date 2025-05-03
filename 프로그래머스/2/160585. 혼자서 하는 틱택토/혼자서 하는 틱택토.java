class Solution {
    /**
    틱택토 규칙을 어긴 경우
    1. 갯수가 맞지 않는 경우
        1 - 1. X의 갯수가 O의 갯수보다 많은 경우 (O가 선공)
        1 - 2. O의 갯수가 X의 갯수보다 2개 이상 많은 경우 (O, X 번갈아 가면서 진행)
    2. O 또는 X가 (선공이나 후공이) 승리했음에도 계속해서 진행하는 경우
    */
    public int solution(String[] board) {
        
        char[][] matrix = new char[board.length][board[0].length()];
        for (int i = 0; i < board.length; i++) {
            matrix[i] = board[i].toCharArray();
        }
        
        // 1번 => 갯수가 다른 경우
        int o_cnt = countTicTacToe('O', matrix);
        int x_cnt = countTicTacToe('X', matrix);    
        
        if (x_cnt > o_cnt) {
            return 0;
        } else if (o_cnt > x_cnt + 1) {
            return 0;
        }
        
        // 2번 => O 또는 X가 (선공이나 후공이) 승리했음에도 계속해서 진행하는 경우
        
        boolean o_win = isTicTacToeWin('O', matrix);
        boolean x_win = isTicTacToeWin('X', matrix);
        
        if (x_win && o_cnt >= x_cnt + 1) {
            return 0;
        } else if (o_win && x_cnt >= o_cnt) {
            return 0;
        }
        
        return 1;
    }
    
    public int countTicTacToe(char sign, char[][] matrix) {
        int cnt = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (char p : matrix[i]) {
                if (p == sign) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
    
    public boolean isTicTacToeWin(char sign, char[][] matrix) {
        
        // 가로 검증
        for (int i = 0; i < matrix.length; i++) {    
            if (matrix[i][0] == sign && matrix[i][1] == sign && matrix[i][2] == sign) {
                return true;
            }
        }
        
        // 세로 검증
        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[0][j] == sign && matrix[1][j] == sign && matrix[2][j] == sign) {
                return true;
            }                     
        }
        
        // 대각선 검증
        if (matrix[0][0] == sign && matrix[1][1] == sign && matrix[2][2] == sign) {
            return true;
        }
        
        if (matrix[0][2] == sign && matrix[1][1] == sign && matrix[2][0] == sign) {
            return true;
        }
        
        return false;
        
    }
}