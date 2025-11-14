# Rotting Oranges

**Category:** Graphs (NeetCode)  
**Difficulty:** Medium  
**Time Complexity:** O(m × n)  
**Space Complexity:** O(m × n)

## Problem Description
You are given an `m x n` grid where each cell can be:
* `0` — empty  
* `1` — fresh orange  
* `2` — rotten orange  

Every minute, each rotten orange can rot adjacent fresh oranges (up, down, left, right).  
Return the **minimum number of minutes** until all oranges become rotten.

If some fresh oranges can never rot, return `-1`.

## Approach
* Use BFS traversal technique by adding all rotten oranges at minute 0 into the queue. 
* Count the number of fresh oranges at the start. 
* BFS goes level by level through the queue while it is not empty and the number of fresh oranges is greater than 0. Each level will be 1 minute incremented. 
* Whenever a fresh orange becomes rotten, decrement the fresh count and add it to the queue.  
* After the queue is empty, and if there is still a fresh fruit remaining as fresh > 0, then return -1. Otherwise, return minutes;


## Example
**Input:**
[[2,1,1],

[1,1,0],

[0,1,1]]

**Output:**  
`4`

**Explanation:**  
Each minute a new layer of oranges rots. All oranges rot in 4 minutes.

## Java Code
```java
public class RottingFruit {
	public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int minutes = 0;
        int fresh = 0;
        Queue <int[]> q = new LinkedList<>();
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if(grid[r][c] == 1){
                    fresh++;
                }
                if(grid[r][c] == 2){
                    q.add(new int[] {r,c});
                }
            }
        }
        
        int[][] directions = new int[][] { {-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        while(fresh > 0 && !q.isEmpty()){
            int length = q.size();
            for(int i = 0; i < length; i++){
                int[] current = q.poll();
                int r = current [0];
                int c = current [1];

                for(int[] dir: directions){
                    int newRow = r + dir[0];
                    int newCol = c + dir[1];
                    if(newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols 
                    && grid[newRow][newCol] == 1){
                        grid[newRow][newCol] = 2;
                        fresh--;
                        q.add(new int[] {newRow,newCol});
                    }
                }
            }
            minutes++;
        }
        return fresh == 0 ? minutes: -1;


        
    }
}
