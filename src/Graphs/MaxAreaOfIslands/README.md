# Max Area of Island

**Category:** Graphs (NeetCode) 
 
**Difficulty:** Medium  

**Time Complexity:** O(m × n)  

**Space Complexity:** O(m × n)

## Problem Description
You are given an `m × n` binary grid representing a map of `1`s (land) and `0`s (water). Return the **area of the largest island** — the number of land cells connected vertically or horizontally.

## Approach
* Use **DFS** to explore each island.  
* Maintain a running counter for each connected region and update the global maximum.  
* When you encounter a `1`, recursively mark connected land as visited (turn to `0`) and count cells.  
* Return the maximum count obtained across all islands.

## Example
**Input:**  
grid = [

[0,0,1,0,0,0,0,1,0,0,0,0,0],

[0,0,0,0,0,0,0,1,1,1,0,0,0],

[0,1,1,0,1,0,0,0,0,0,0,0,0],

[0,1,0,0,1,1,0,0,1,0,1,0,0],

[0,1,0,0,1,1,0,0,1,1,1,0,0],

[0,0,0,0,0,0,0,0,0,0,1,0,0],

[0,0,0,0,0,0,0,1,1,1,0,0,0],

[0,0,0,0,0,0,0,1,1,0,0,0,0]

]

**Output:** `6`

**Explanation:**  
The island with area 6 is the largest connected group of `1`s.

## Java Code
```java
public class MaxAreaOfIslands {
	class Solution {
	    public int maxAreaOfIsland(int[][] grid) {
	        int maxArea = 0;
	        int rows = grid.length;
	        int cols = grid[0].length;
	        for(int r = 0; r < rows; r++){
	            for(int c = 0; c < cols; c++){
	                if(grid[r][c] == 1){
	                int area = dfs(grid, r, c);
	                maxArea = Math.max(area, maxArea);
	                }
	            }
	        }
	        return maxArea;
	    }
	    public int dfs(int[][] grid, int r, int c){
	        int rows = grid.length;
	        int cols = grid[0].length;
	        if(r < 0 || c < 0 || c >= cols || r>= rows || grid[r][c] == 0){
	            return 0;
	        }
	        grid[r][c] = 0;

	        int area = 1;
	        area += dfs(grid, r - 1, c);
	        area += dfs(grid, r + 1, c);
	        area += dfs(grid, r, c - 1);
	        area += dfs(grid, r, c + 1);
	       

	        return area;
	       
	        
	    }
	}
}
