#Maximum Depth of Binary Tree  

**Category:** Trees (NeetCode)  

**Difficulty:** Easy  

**Time Complexity:** O(n)  

**Space Complexity:** O(h)  

#Problem Description:  
Given the root of a binary tree, return its maximum depth. The maximum depth is the number of nodes along the longest path from the root down to the farthest leaf node.  

#Approach:  
- We use **recursion** to compute the depth of each subtree.  
- If the current node is `null`, return `0`.  
- Otherwise, return the greater of the left and right subtree depths plus 1. The plus 1 counts the current node.    
- This recursive approach counts depth from bottom up, using the call stack to unwind.  

#Example:  
**Input:**  
root = [3,9,20,null,null,15,7]

**Output:**
 `3`  

**Explanation:** The longest path is [3,20,7], so the depth is 3.  

#Java Code:
```java
public static int maxDepth(TreeNode root) {
        if(root == null)
        	return 0;
        else {
        	return Math.max(maxDepth(root.left),maxDepth(root.right)) + 1;
        }
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
