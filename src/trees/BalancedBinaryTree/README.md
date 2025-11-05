#Balanced Binary Tree

**Category:** Trees (NeetCode)

**Difficulty:** Easy

**Time Complexity:** O(n)

**Space Complexity:** O(h)

#Problem Description:
Given the root of a binary tree, determine if it is height-balanced. A binary tree is balanced if the height of the two subtrees of every node never differ by more than one.

#Approach:
- Call a helper function called getHeight, which will create two variables, one on the left, and one on the right, to recursively traverse through the tree all the way down. 
- It will determine if it the node is balanced using Math.abs, and if not, return -1 immediately. 
- If the function has completed iterating through all the nodes, and they are balanced, it will return the height using Math.max. 
- We do not need to return the height, but our condition is as long as the function does not return -1, which would be returned if any of the nodes were not balanced. 

#Example:
**Input:**
root = [3,9,20,null,null,15,7]

**Output:**
`true`

**Explanation:**  
The left subtree has height 1 and the right subtree has height 2, so the tree is balanced.

#Java Code:
```java
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
		return getHeight(root) != -1;
    }
	public int getHeight (TreeNode node) {
	if(node == null)
		return 0;
	
	int leftHeight = getHeight(node.left);
	if(leftHeight == -1)
		return -1;
	
	int rightHeight = getHeight (node.right);
	if(rightHeight == -1)
		return -1;
	
	if(Math.abs(leftHeight - rightHeight) > 1)
		return -1;
	
	return Math.max(leftHeight, rightHeight) + 1;
}
}