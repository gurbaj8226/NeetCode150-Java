# Valid Sudoku

**Category:** Arrays & Hashing (NeetCode)  
**Difficulty:** Medium  
**Time Complexity:** O(1) — always 81 cells  
**Space Complexity:** O(1)

## Problem Description
Determine if a `9 x 9` Sudoku board is valid.  
A board is valid if:

* Each **row** contains no duplicates (ignoring `.`).
* Each **column** contains no duplicates.
* Each **3×3 sub-box** contains no duplicates.

This problem does **not** require checking if the Sudoku is solvable—only whether current placement is valid.

## Approach
Use 3 hash sets for each row, column, and box:

* For each cell `(r, c)`:
  * If the value is `.`, skip.
  * Check:
    * Row set for row `r`
    * Column set for column `c`
    * Box set for index `(r/3) * 3 + (c/3)`
  * If the value exists in any of the sets → invalid.
  * Otherwise, add it.

## Example
**Input (partial):**
[
["5","3",".",".","7",".",".",".","."],
["6",".",".","1","9","5",".",".","."],
[".","9","8",".",".",".",".","6","."],
...
]

**Output:**  
`true`

## Java Code
```java

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
