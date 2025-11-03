#Same Tree  

**Category:** Trees (NeetCode)  

**Difficulty:** Easy  

**Time Complexity:** O(n)  

**Space Complexity:** O(h)  

#Problem Description:  
Given the roots of two binary trees `p` and `q`, write a function to determine if they are the same. Two binary trees are considered the same if they are structurally identical and the nodes have the same value.  

#Approach:  
- We use **recursion** to traverse both trees simultaneously.  
- If both nodes are `null`, we return `true`.  
- If one of them is `null` or their values differ, we return `false`.  
- Otherwise, we recursively compare their left and right subtrees.  
- This follows a **Depth-First Search (DFS)** pattern where each node comparison goes deeper into both trees.  

#Example:  
**Input:**  
p = [1,2,3]

q = [1,2,3]

**Output:** 
`true` 
 
**Explanation:** Both trees have the same structure and node values.  

#Java Code:
```java
public class SameTree {

	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		}
		if (p != null && q != null && p.val == q.val) {
			return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
		} else
			return false;
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}