# Clone Graph

**Category:** Graphs (NeetCode)  

**Difficulty:** Medium  

**Time Complexity:** O(V + E)  

**Space Complexity:** O(V)

## Problem Description
Given a reference to a node in a connected undirected graph, return a **deep copy** (clone) of the graph.  Each node contains a value and a list of neighbors.

## Approach
* Use a **HashMap** to map each original node to its cloned node.  
* Perform **BFS** or **DFS** traversal.  
* For each node, clone its neighbors recursively or iteratively.  
* The map ensures no node is cloned more than once and handles cycles correctly.

## Example
**Input:**  
adjList = [[2,4],[1,3],[2,4],[1,3]]

**Output:**  
[[2,4],[1,3],[2,4],[1,3]]

**Explanation:**  
The cloned graph has the same connections as the original.

## Java Code
```java
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
public class CloneGraph {
	

	class Solution {
	    Map <Node, Node> visited = new HashMap<>();
	    public Node cloneGraph(Node node) {
	        if(node == null){
	            return node;
	        }
	        if(visited.containsKey(node)){
	            return visited.get(node);
	        }

	        Node clone = new Node(node.val, new ArrayList<>());

	        visited.put(node, clone);

	        for(Node neighbor: node.neighbors){
	            clone.neighbors.add(cloneGraph(neighbor));
	        }
	        return clone;
	        
	        
	    }
	}
}
