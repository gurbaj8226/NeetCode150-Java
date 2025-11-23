# Redundant Connection

**Category:** Graphs (NeetCode)  
**Difficulty:** Medium  
**Time Complexity:** O(V + E*(a(V)))  
**Space Complexity:** O(V)

## Problem Description
You are given a list of edges representing a graph that originally formed a **tree** (connected with no cycles).  
However, one extra edge was added, creating a **cycle**.

Return the **edge** that, when removed, restores the graph to a tree.  
If multiple edges could be removed, return the **last** one in the input order.

## Approach
* Use **Union-Find (Disjoint Set)** without rank.  
* For each edge `[u, v]`:
  - If `find(u) == find(v)`, then `u` and `v` already share the same root → this edge forms a **cycle** → return it.
  - Otherwise, union the sets by attaching one root to the other.
* `find()` uses **path compression** to flatten the tree for faster future lookups.

## Example
**Input:**  
`edges = [[1,2],[1,3],[2,3]]`

**Output:**  
`[2,3]`

**Explanation:**  
The edge `[2,3]` is the one that completes a cycle, so removing it restores the graph to a tree.

## Java Code
```java
public class RedundantConnection {
	public int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[edges.length + 1];
        for(int i = 1; i <= edges.length; i++){
            parent[i] = i;
        }

        for(int[] edge: edges){
            int node1 = edge[0];
            int node2 = edge[1];

            int root1 = find(parent, node1);
            int root2 = find(parent, node2);

            if(root1 == root2){
                return edge;
            }

            parent[root2] = root1; 
        }

        return new int[0];
    }

    public int find(int[] parent, int node){
        while(node != parent[node]){
            parent[node] = parent[parent[node]];
            node = parent[node];
        }
        return node;
    }
}

