# Walls and Gates

**Category:** Graphs (NeetCode)  
**Difficulty:** Medium  
**Time Complexity:** O(m × n)  
**Space Complexity:** O(m × n)

## Problem Description  
You are given a 2D grid representing rooms in a building.  
Each cell contains one of the following:

* **0** → a gate  
* **-1** → a wall  
* **INF (2147483647)** → an empty room  

Fill each empty room with the **distance to its nearest gate**.  
If a room cannot reach any gate, leave it as INF.

## Approach  
* Use **multi-source BFS** by inserting **all gates** into the queue at the start.  
* BFS spreads level-by-level, guaranteeing shortest distance to each reachable room.  
* For each cell popped from the queue, explore its 4 neighbors: up, down, left, right.  
* When encountering an **INF** room, update it to `currentDistance + 1` and add it to the queue.  
* Walls (`-1`) are skipped automatically because they are never enqueued.

This ensures every room gets the minimum distance to the nearest gate.

## Example  
**Input:**
INF  -1   0   INF

INF INF INF  -1

INF  -1 INF  -1

0    -1 INF INF

**Output:**
3  -1   0   1

2   2   1  -1

1  -1   2  -1

0  -1   3   4

## Java Code
```java
public class WallsAndGates {
	public void islandsAndTreasure(int[][] grid) {
        Queue <int[]> q = new LinkedList<>();
        int rows = grid.length;
        int cols = grid[0].length;
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if(grid[r][c] == 0){
                    q.add(new int[] {r, c});
                }
            }
        }
        if(q.size() == 0){
            return;
        }
        int[][] directions = new int[][] {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        while(!q.isEmpty()){
            int[] current = q.poll();
            int currentRow = current[0];
            int currentCol = current[1];

            for(int[] dir: directions){
                int r = currentRow + dir[0];
                int c = currentCol + dir[1];

                if(r >= rows || c >= cols || r < 0 || c < 0 || grid[r][c] != Integer.MAX_VALUE){
                    continue;
                }
                q.add(new int[] {r, c});
                grid[r][c] = grid[currentRow][currentCol] + 1;
            }
        }
	}
}

