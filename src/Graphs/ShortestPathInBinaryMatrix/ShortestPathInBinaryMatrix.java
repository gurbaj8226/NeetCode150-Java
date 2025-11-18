package Graphs.ShortestPathInBinaryMatrix;

import java.util.LinkedList;
import java.util.Queue;

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
