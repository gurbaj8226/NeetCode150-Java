#Lowest Common Ancestor of a Binary Search Tree (LeetCode 235)


Category: Trees (NeetCode 150)

Difficulty: Medium

Time Complexity: O(H) — height of tree

Space Complexity: O(1) (if iterative)

## Problem Description


Given the root of a Binary Search Tree (BST) and two nodes p and q, find their lowest common ancestor (LCA).

The lowest common ancestor is the lowest node in the tree that has both p and q as descendants.

## Approach
Utilize BST properties:

- In a Binary tree, the left node will be smaller than the parent and the right node will be larger than the parent. 
- If p and q are both larger than that node, then go right, if they are both smaller go left, and if the node is in the middle of them, then simply return that node. 


## Example


Input:

       6
      / \
     2   8
    / \ / \
   0  4 7  9
     / \
    3   5

p = 2, q = 8
Output:

6
Explanation: Node 6 is the lowest node having both 2 and 8 as descendants.

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

class LowestCommonAncestor {

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		TreeNode current = root;
		while (current != null) {
			if (p.val > current.val && q.val > current.val) {
				current = current.right;
			}
			if (p.val < current.val && q.val < current.val) {
				current = current.left;
			} else {
				return current;
			}
		}
		return null;
	}
}