package Graphs.NumberOfComponentsInUndirectedGraph;

import java.util.ArrayList;
import java.util.List;

public class NumberOfComponentsInUndirectedGraph {
	public int countComponents(int n, int[][] edges) {
        int counter = 0;
        int[] visited = new int[n];

        List <Integer>[] adj = new ArrayList[n];
        for(int i = 0; i < n; i++){
            adj[i] = new ArrayList<Integer>();
        }
        for(int i = 0; i < edges.length; i++){
            adj[edges[i][0]].add(edges[i][1]);
            adj[edges[i][1]].add(edges[i][0]);
        }

        for(int i = 0; i < n; i++){
            if(visited[i] == 0){
                counter++;
                dfs(adj, visited, i);
            }
        }
        return counter;
    }
    public void dfs(List<Integer>[] adj, int[] visited, int node){
        visited[node] = 1;
        
        for(int i = 0; i < adj[node].size(); i++){
            if(visited[adj[node].get(i)] == 0){
                dfs(adj, visited, adj[node].get(i));
            }
        }
    }
}
