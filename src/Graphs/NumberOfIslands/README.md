# Number of Islands

**Category:** Graphs (NeetCode)  

**Difficulty:** Medium  

**Time Complexity:** O(m × n)  

**Space Complexity:** O(m × n)

## Problem Description
Given a 2D grid of `'1'`s (land) and `'0'`s (water), return the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.

## Approach
* Use **DFS** or **BFS** to traverse connected land cells.  
* When you find a `'1'`, perform a traversal to mark all connected `'1'`s as visited (turn them into `'0'`).  
* Increment your island counter each time you initiate a traversal.  
* This ensures each land cluster is counted exactly once.

**DFS version** uses recursion to explore up/down/left/right.  
**BFS version** uses a queue to visit all connected nodes.

## Example
**Input:**  
grid = [

[“1”,“1”,“0”,“0”,“0”],

[“1”,“1”,“0”,“0”,“0”],

[“0”,“0”,“1”,“0”,“0”],

[“0”,“0”,“0”,“1”,“1”]

]

**Output:** `3`

**Explanation:**  
There are 3 separate islands in the grid.

## Java Code
```java
public class NumberOfIslands {
	public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int numOfIslands = 0;

        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if(grid[r][c] == '1'){
                    dfs(grid, r, c);
                    numOfIslands++;
                }
            }
        }
        return numOfIslands;
    }
    public void dfs(char[][] grid, int r, int c){
        int rows = grid.length;
        int cols = grid[0].length;

        if(r < 0 || c < 0 || r >= rows || c >= cols || grid[r][c] == '0'){
            return;
        }

        grid[r][c] ='0';

        dfs(grid, r, c + 1);
        dfs(grid, r, c - 1);
        dfs(grid, r + 1, c);
        dfs(grid, r - 1, c);
    }
}