# Shortest Path in Binary Matrix

**Category:** Graphs (BFS Template)  
**Difficulty:** Medium  
**Time Complexity:** O(n²)  
**Space Complexity:** O(n²)

## Problem Description  
You are given an `n x n` binary matrix where:

* `0` → open cell  
* `1` → blocked cell  

You must return the **length of the shortest clear path** from the top-left `(0,0)` to the bottom-right `(n-1,n-1)`.

A clear path must:
* Only move through `0` cells  
* Move in **8 directions** (horizontal, vertical, diagonal)

If no path exists, return `-1`.

## Approach  
* Use **BFS** because it guarantees the shortest path in an **unweighted grid**.  
* Start BFS from `(0,0)` if it is not blocked.  
* Maintain a `visited` matrix to avoid revisiting.  
* At each step, explore all **8 directions**:  
  `(1,0), (-1,0), (0,1), (0,-1), (1,1), (-1,-1), (1,-1), (-1,1)`  
* Track distance by either storing `(r, c, dist)` or computing `rooms[r][c] + 1`.  
* Return the distance if you reach `(n-1,n-1)`.

If the BFS ends without reaching the bottom-right, return `-1`.

## Example  
**Input:**
[

[0,1],

[1,0]

]

**Output:**
2

## Java Code
```java
public class ShortestPathInBinaryMatrix {
	public int shortestPathBinaryMatrix(int[][] grid) {
        int[][] directions = new int[][] {
            {1, 1}, {0, 1}, {1, 0}, {-1, 1}, {1, -1}, {0, -1}, {-1, 0}, {-1, -1}
        };

        int n = grid.length;
        Queue <int[]> q = new LinkedList<>();
        if(grid[0][0] == 1){
            return -1;
        }
        q.add(new int[] {0, 0});
        int path = 1;
        grid[0][0] = 1;
        while(!q.isEmpty()){
            int level = q.size();
            for(int i = 0; i < level; i++){
                int[] current = q.poll();
                int cr = current[0];
                int cc = current[1];
                
                if(cc == n - 1 && cr == n - 1){
                    return path;
                }
                for(int[] dir: directions){
                    int nr = cr + dir[0];
                    int nc = cc + dir[1];

                    if(nr < 0 || nc < 0 || nr >= n || nc >= n || grid[nr][nc] != 0){
                        continue;
                    }
                    q.add(new int[] {nr, nc});
                    grid[nr][nc] = 1;
                }
            }
            path++;
        }
        return -1;
    }
}
