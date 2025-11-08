# Binary Tree Maximum Path Sum

**Category:** Binary Tree (NeetCode)  

**Difficulty:** Hard  

**Time Complexity:** O(n)  

**Space Complexity:** O(h), where h is the height of the tree

## Problem Description:
A **path** in a binary tree is a sequence of nodes connected by edges. A path’s **sum** is the sum of the node values along that path. The path does not need to pass through the root.  
Return the **maximum path sum** of any path in the binary tree.

## Approach:
- Use post-order traversal (DFS) to compute the maximum gain from each subtree.  
- Get the maximum of the function call from both left and right roots, and 0, as we want to skip over any negative numbers. 
- Update the current path as the root value, plus the left and right node values, and then use Math.max to update the global variable. 
- Return root.val + max(left, right) for when we recursively call the function from leftSide and rightSide, to essentially just get the greatest path as we can only pick one. 

## Example:
**Input:**  
`root = [-10,9,20,null,null,15,7]`  

**Output:**  
`42`

**Explanation:**  
The path `[15,20,7]` gives the maximum sum of **42**.

## Java Code:
```java
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

public class BinaryTreeMaximumPathSum {
	int maxSum = Integer.MIN_VALUE;

	public int max(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int leftSide = Math.max(max(root.left), 0);
		int rightSide = Math.max(max(root.right), 0);

		int currentPath = root.val + leftSide + rightSide;

		maxSum = Math.max(maxSum, currentPath);

		return root.val + Math.max(leftSide, rightSide);
	}

	public int maxPathSum(TreeNode root) {
		max(root);
		return maxSum;
	}
}
