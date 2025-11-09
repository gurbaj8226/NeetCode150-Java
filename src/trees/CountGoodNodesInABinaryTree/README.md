# Count Good Nodes in Binary Tree

**Category:** Trees (NeetCode)  
**Difficulty:** Medium  
**Time Complexity:** O(n)  
**Space Complexity:** O(h) – height of the tree (recursion stack)

## Problem Description:
Given a binary tree `root`, a node `X` in the tree is named **good** if in the path from the root to `X` there are no nodes with a value greater than `X`.

Return the number of good nodes in the binary tree.

## Approach:
- Perform a **DFS traversal** starting from the root.
- Keep track of the **maximum value** seen so far on the path.
- At each node:
  - If `root.val >= max`, it’s a “good node”.
  - Update `max` to `Math.max(max, root.val)`.
- Recursively count the number of good nodes in the left and right subtrees.

## Example:
**Input:**
    3
   / \
  1   4
 /   / \
3   1   5
**Output:**  
`4`

**Explanation:**  
The "good" nodes are `[3, 3, 4, 5]`.

## Java Code:
```java
public class CountGoodNodesInABinaryTree {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }
        if(root == p || root == q){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left != null && right != null){
            return root;
        }
        return left != null ? left : right;
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