# Graph Valid Tree

**Category:** Graphs (DFS / Union-Find Concept)  
**Difficulty:** Medium  
**Time Complexity:** O(n + e)  
**Space Complexity:** O(n + e)

## Problem Description  
You are given `n` nodes labeled `0` to `n - 1` and an array of undirected `edges`.  
Your task is to determine whether these edges form a **valid tree**.

A graph is a valid tree if:
* It is **connected** (every node can be reached from node `0`)  
* It contains **no cycles**  
* It has **exactly `n - 1` edges**  

## Approach  
* First check if `edges.length > n - 1`.  
  * A tree with `n` nodes cannot have more than `n - 1` edges → immediately invalid.  
* Build an **undirected adjacency list** for the graph.  
* Use **DFS** starting at node `0` to detect cycles:  
  * Maintain a `visited` set  
  * Pass a `parent` value so the undirected edge back to the parent is ignored  
  * If we ever revisit a node that is already visited, a cycle exists  
* After DFS completes, check that the number of visited nodes equals `n`.  
  * If not all nodes were visited, the graph is disconnected → not a tree.

## Example  
**Input:**  
n = 5  
edges = [[0,1],[0,2],[0,3],[1,4]]

**Output:**  
true

**Explanation:**  
The graph has exactly `4` edges (`n - 1`), is fully connected, and contains no cycles —  
therefore, it forms a valid tree.

##Java Code
```Java
public class GraphValidTree {
	 public boolean validTree(int n, int[][] edges) {
	        if(edges.length > n - 1){
	            return false;
	        }
	        List<List<Integer>> adj = new ArrayList<>();

	        for(int i = 0; i < n; i++){
	            adj.add(new ArrayList<>());
	        }
	        for(int[] edge: edges){
	            adj.get(edge[0]).add(edge[1]);
	            adj.get(edge[1]).add(edge[0]);
	        }

	        Set <Integer> visit = new HashSet<>();
	        if(!dfs(0, -1, visit, adj)){
	            return false;
	        }
	        return visit.size() == n;

	    }
	    public boolean dfs(int node, int parent, Set <Integer> visit, List<List<Integer>> adj){
	        if(visit.contains(node)){
	            return false;
	        }
	        visit.add(node);
	        for(int neighbor: adj.get(node)){
	            if(neighbor == parent){
	                continue;
	            }
	            if(!dfs(neighbor, node, visit, adj)){
	                return false;
	            }
	        }
	        return true;
	    }
}
