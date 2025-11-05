#Invert Binary Tree

**Category:** Trees (NeetCode)

**Difficulty:** Easy

**Time Complexity:** O(n)

**Space Complexity:** O(h)

#Problem Description:
Given the root of a binary tree, invert the tree and return its root. Inverting means swapping every left and right child of all nodes.

#Approach:
- Use **recursion (DFS)** to traverse each node.
- At each node, swap its left and right children using a temp variable to hold the value.
- Then recursively call the function on both subtrees.

#Example:
**Input:**
root = [4,2,7,1,3,6,9]

**Output:**
[4,7,2,9,6,3,1]

**Explanation:**  
Each left and right subtree is flipped recursively to form a mirror image.

#Java Code:
```java
public TreeNode invertTree(TreeNode root) {
		if(root ==null) {
			return null;
		}
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		
		invertTree(root.left);
		invertTree(root.right);
		
		return root;
    }
}
class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode() {}
	      TreeNode(int val) { this.val = val; }
	      TreeNode(int val, TreeNode left, TreeNode right) {
	          this.val = val;
	          this.left = left;
	          this.right = right;
	      }
	  }