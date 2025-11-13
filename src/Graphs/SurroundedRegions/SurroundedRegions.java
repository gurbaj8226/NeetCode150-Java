package Graphs.SurroundedRegions;

public class SurroundedRegions {
	public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if((r == 0 || c == 0 || r == rows - 1 || c == cols - 1) && board[r][c] == 'O'){
                    dfs(board, r, c);
                }
            }
        }
         for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if(board[r][c] == 'O'){
                    board[r][c] = 'X';
                } else if (board[r][c] == 'T'){
                    board[r][c] = 'O';
                }
            }
         }
    }
    public void dfs (char[][] board, int r, int c){
        if(r < 0 || c < 0 || r >= board.length || c >= board[0].length || board[r][c] != 'O'){
            return;
        }
        board[r][c] = 'T';
        dfs(board, r + 1, c);
        dfs(board, r - 1, c);
        dfs(board, r, c + 1);
        dfs(board, r, c - 1);
    }
}
