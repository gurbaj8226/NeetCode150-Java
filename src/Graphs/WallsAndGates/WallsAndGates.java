package Graphs.WallsAndGates;

import java.util.LinkedList;
import java.util.Queue;

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
