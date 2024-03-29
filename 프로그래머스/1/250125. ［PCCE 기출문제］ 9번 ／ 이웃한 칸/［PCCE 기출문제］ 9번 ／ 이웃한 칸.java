class Solution {
    public int solution(String[][] board, int h, int w) {
        int n = board.length;
        int[] dh = {0, 1, -1, 0};
        int[] dw = {1, 0, 0, -1};
        int count = 0;
        
        for(int i = 0; i < 4; i++) {
            int hCheck = h + dh[i];
            int wCheck = w + dw[i];
            
            if(hCheck >= 0 && wCheck >= 0 && hCheck < n && wCheck < n) {
                if(board[h][w].equals(board[hCheck][wCheck])) count++;
            }
        }
        
        return count;
    }
}