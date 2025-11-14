package Graphs.RottingFruit;

import java.util.LinkedList;
import java.util.Queue;

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
