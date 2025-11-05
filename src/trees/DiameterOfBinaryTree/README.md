# Diameter of Binary Tree

**Category:** Trees (NeetCode)

**Difficulty:** Easy

**Time Complexity:** O(n)

**Space Complexity:** O(h)

---

## Problem Description:
Given the root of a binary tree, return the *length of the diameter* of the tree.

The **diameter** of a binary tree is defined as the **length of the longest path between any two nodes** in the tree. This path **may or may not pass through the root**. The length of a path between two nodes is represented by the **number of edges** between them.

---

## Approach:
- Use DFS recursion with a helper method to get the height of each subtree. 
- An instance variable called diameter is initialized so each search has its own max diameter count. 
- A helper function depth(TreeNode node), will use recursion to calculate the height of each node. It does this by returning 1 + the greater of the left and right nodes. 
- The helper function will also update Diameter by using Math.max() of left + right, to consider all paths, not just from bottom to top. 

---

## Example:
**Input:**
root = [1,2,3,4,5]

**Output:**
3

**Explanation:**
The longest path is `[4,2,1,3]` or `[5,2,1,3]`, which contains 3 edges.

---

## Code Implementation (Java):
```java
public class DiameterOfBinaryTree {
    private int diameter;

    public int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        depth(root);
        return diameter;
    }

    public int depth(TreeNode node) {
        if (node == null)
            return 0;

        int left = depth(node.left);
        int right = depth(node.right);

        diameter = Math.max(diameter, left + right);

        return 1 + Math.max(left, right);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
