#Valid Binary Search Tree (LeetCode 98)


Category: Trees (NeetCode 150)

Difficulty: Medium

Time Complexity: O(N)

Space Complexity: O(H) — height of tree

## Problem Description


Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST satisfies:

The left subtree of a node contains only nodes with keys less than the node’s key.

The right subtree of a node contains only nodes with keys greater than the node’s key.

Both left and right subtrees must also be binary search trees.

## Approach
- We are essentially going from the left node, to the parent node, to the right node. 
- When going to the first node on the left, the prev = null, so we will simply make that node the prev during that iteration. 
- Afterwards, we will check if the parent node is greater than the left node, and then make sure the right node is greater than the parent node. 



## Example


Input:

    2
   / \
  1   3
Output:

true
Explanation: The tree follows BST ordering rules.

## Java Code
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

class ValidBinarySearchTree {

	public Integer prev;

	public boolean isValidBST(TreeNode root) {
		prev = null;
		return inOrder(root);

	}

	public boolean inOrder(TreeNode root) {
		if (root == null)
			return true;

		if (!inOrder(root.left)) {
			return false;
		}
		if (prev != null && root.val <= prev)
			return false;

		prev = root.val;
		return inOrder(root.right);
	}
}