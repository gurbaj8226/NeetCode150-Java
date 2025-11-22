# Word Search

**Category:** Graphs (NeetCode)  
**Difficulty:** Medium  
**Time Complexity:** O(m × 4^n)  
**Space Complexity:** O(n)

## Problem Description
Given an `m x n` board of characters and a string `word`,  
return `true` if the word exists in the grid.  
The word must be constructed from letters of sequentially adjacent cells  
(up, down, left, right), and the same cell may not be used more than once.

## Approach
* Use **DFS** to search from every cell that matches `word[0]`.  
* Track visited cells to avoid reuse.  
* At each step, attempt to match the next character by exploring 4 directions.  
* If all characters are matched, return true; otherwise backtrack.

## Example
**Input:**  
board =  
[["A","B","C","E"],  
 ["S","F","C","S"],  
 ["A","D","E","E"]]  
word = "ABCCED"

**Output:**  
true

##Java Code
```Java
public boolean exist(char[][] board, String word) {
	        int rows = board.length;
	        int cols = board[0].length;

	        for(int r = 0; r < rows; r++){
	            for(int c = 0; c < cols; c++){
	                if(dfs(board, word, r, c, 0)){
	                    return true;
	                }
	            }
	        }
	        return false;
	    }
	    public boolean dfs(char[][] board, String word, int r, int c, int index){
	        int rows = board.length;
	        int cols = board[0].length;
	        if(index == word.length()){
	            return true;
	        }
	        if(r < 0 || c < 0 || r >= rows || c >= cols || board[r][c] == '#' || board[r][c] != word.charAt(index)){
	            return false;
	        }
	        board[r][c] = '#';
	        boolean result = dfs(board, word, r + 1, c, index + 1) ||
	                         dfs(board, word, r - 1, c, index + 1) ||
	                         dfs(board, word, r, c + 1, index + 1) ||
	                         dfs(board, word, r, c - 1, index + 1);
	        board[r][c] = word.charAt(index);

	        return result;
	    }   