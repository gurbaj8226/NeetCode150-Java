package Graphs.MaxAreaOfIslands;

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
