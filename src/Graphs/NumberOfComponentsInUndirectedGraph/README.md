# Number of Connected Components in an Undirected Graph

**Category:** Graphs (NeetCode)  
**Difficulty:** Medium  
**Time Complexity:** O(V + E)  
**Space Complexity:** O(V + E)

## Problem Description  
You are given an integer `n` representing the number of nodes labeled `0` to `n-1`,  
and a list of edges where each edge connects two nodes.

Your task is to return the **number of connected components** in the graph.

A connected component is a group of nodes where each node is reachable from any other node in the same group.

## Approach  
* Build an **adjacency list** to represent the graph.  
* Maintain a `visited` set that uses 0 to represent unvisited and 1 as visited.  
* Iterate through all nodes:  
  * If a node is **not visited**, it's the start of a new component.  
  * Run **DFS** to mark all nodes reachable from it as visited.  
  * Increment the component counter.  
* Return the counter.



## Example  
**Input:**
n = 5

edges = [[0,1], [1,2], [3,4]]

**Output:**
2

## Java Code
```java
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
