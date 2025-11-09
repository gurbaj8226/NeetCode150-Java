# Lowest Common Ancestor of a Binary Tree

**Category:** Trees (NeetCode)  
**Difficulty:** Medium  
**Time Complexity:** O(n)  
**Space Complexity:** O(h) – height of the tree (recursion stack)

## Problem Description:
Given a binary tree, find the **lowest common ancestor (LCA)** of two given nodes `p` and `q`.  
The LCA of two nodes `p` and `q` is the lowest node in the tree that has both `p` and `q` as descendants.

## Approach:
- Use **DFS (Depth-First Search)** to recursively search for `p` and `q` in both subtrees.
- **Base Case:**  
  - If the current node is `null`, `p`, or `q`, return it.
- Recurse on the left and right children.
- If both sides return non-null, the current node is the LCA.
- Otherwise, return the non-null result.

## Example:
**Input:**
    3
   / \
  5   1
 / \ / \
6  2 0  8
  / \
 7   4
p = 5, q = 1

**Output:**  
`3`

**Explanation:**  
The lowest common ancestor of nodes `5` and `1` is `3`.

## Java Code:
```java
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) 
        		return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) 
        		return root;
        		
        return left != null ? left : right;
    }
}