# Surrounded Regions

**Category:** Graphs (NeetCode)  
**Difficulty:** Medium  
**Time Complexity:** O(m × n)  
**Space Complexity:** O(m × n)

## Problem Description
You are given a 2D board of `'X'` and `'O'`.  
A region of `'O'` is captured if it is completely surrounded by `'X'`.  
Any `'O'` connected to the border should NOT be flipped.

## Approach
* Start DFS/BFS from all border `'O'` cells and temporarily mark these connected `'O'` cells as safe.  
* After traversal:
  * Flip all remaining `'O'` to `'X'` since they are surrounded.  
  * Convert all safe-marked cells back to `'O'`.  
* This ensures only enclosed regions are captured correctly.

## Example
**Input:**  

X X X X  
X O O X  
X X O X  
X O X X  

**Output:**  

X X X X  
X X X X  
X X X X  
X O X X  

**Explanation:**  
Only the region in the middle is fully surrounded and gets flipped.

## Java Code
```java
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
