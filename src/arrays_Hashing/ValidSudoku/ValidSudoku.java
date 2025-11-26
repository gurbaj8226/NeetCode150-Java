package arrays_Hashing.ValidSudoku;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
public boolean isValidSudoku(char[][] board) {
        
        for(int r = 0; r < 9; r++){
            Set <Character> seen = new HashSet<>();

            for(int i = 0; i < 9; i++){
                if(board[r][i] == '.'){
                    continue;
                }
                if(seen.contains(board[r][i])){
                    return false;
                }
                seen.add(board[r][i]);
            }
        }

        for(int c = 0; c < 9; c++){
            Set <Character> seen = new HashSet<>();
            for(int i = 0; i < 9; i++){
                if(board[i][c] == '.'){
                    continue;
                }
                if(seen.contains(board[i][c])){
                    return false;
                }
                seen.add(board[i][c]);
            }
        }

        for(int square = 0; square < 9; square++){
            Set <Character> seen = new HashSet<>();
            for(int r = 0; r < 3; r++){
                for(int c = 0; c < 3; c++){
                    int row = (square/3)*3 + r;
                    int col = (square % 3) * 3 + c;

                    if(board[row][col] == '.'){
                        continue;
                    }
                    if(seen.contains(board[row][col])){
                        return false;
                    }
                    seen.add(board[row][col]);
                }
            }
        }
        return true;
    }
}
