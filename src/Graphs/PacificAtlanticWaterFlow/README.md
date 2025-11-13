# Pacific Atlantic Water Flow

**Category:** Graphs (NeetCode)  
**Difficulty:** Medium  
**Time Complexity:** O(m × n)  
**Space Complexity:** O(m × n)

## Problem Description
You are given an `m x n` matrix of heights. Water can flow from one cell to another if the next cell's height is less than or equal to the current one.  
The Pacific Ocean touches the top and left edges of the grid.  
The Atlantic Ocean touches the bottom and right edges.  
Return all coordinates from which water can flow to **both** oceans.

## Approach
* Use **reverse DFS/BFS** starting from Pacific-border cells and Atlantic-border cells.  
* Maintain two visited matrices:
  * `pacific` — cells reachable from the Pacific Ocean  
  * `atlantic` — cells reachable from the Atlantic Ocean  
* From the corresponding borders, traverse inward only if the next height is >= current height.  
* After filling both matrices, all coordinates reachable by **both** oceans are part of the result.

## Example
**Input:**  

heights = [
[1,2,2,3,5],
[3,2,3,4,4],
[2,4,5,3,1],
[6,7,1,4,5],
[5,1,1,2,4]
]

**Output:**  
`[[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]`

**Explanation:**  
Using reverse flow logic, these cells can reach both oceans.

## Java Code
```java
public class PacificAtlanticWaterFlow {
	public List<List<Integer>> pacificAtlantic(int[][] heights) {
        if(heights.length == 0 || heights[0].length == 0){
            return new ArrayList<>();
        }
        int row = heights.length;
        int col = heights[0].length;
        boolean[][] pacific = new boolean[row][col];
        boolean[][] atlantic = new boolean[row][col];
        for(int i = 0; i < row; i++){
            dfs(i, 0, pacific, heights);
            dfs(i, col - 1, atlantic, heights);
        }
        for(int i = 0; i < col; i++){
            dfs(0, i, pacific, heights);
            dfs(row - 1, i, atlantic, heights);
        }
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(pacific[i][j] && atlantic[i][j]){
                    result.add(Arrays.asList(i,j));
                }
            }
        }
        return result;

    }
    public void dfs (int row, int col, boolean[][] reachable, int[][]heights){
        int[][] directions = new int[][] {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        reachable[row][col] = true;
        for(int[] dir: directions){
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            if(newRow < 0 || newRow >=heights.length || newCol < 0 || newCol >=heights[0].length){
                continue;
            }
            if(reachable[newRow][newCol]){
                continue;
            }
            if(heights[newRow][newCol] >= heights[row][col]){
                dfs(newRow, newCol, reachable, heights);
            }
        }
    }
}
