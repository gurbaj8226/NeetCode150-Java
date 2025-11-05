#Subtree of Another Tree

**Category:** Trees (NeetCode)

**Difficulty:** Easy

**Time Complexity:** O(m * n)

**Space Complexity:** O(h)

#Problem Description:
Given the roots of two binary trees `root` and `subRoot`, return `true` if there is a subtree of `root` with the same structure and node values as `subRoot`.

#Approach:
- If the root is null, then return false because an empty tree cannot have a subtree within it. 
- Otherwise, call the helper function which determines if the nodes at that level are equal. It will continue to call itself to confirm that the entire subtree is present. 
- If it does not return true, then move onto the next level by recursively calling from both the left and right. 

#Example:
**Input:**
root = [3,4,5,1,2]  
subRoot = [4,1,2]

**Output:**
`true`

**Explanation:**  
The subtree rooted at node 4 in `root` matches `subRoot`.

#Java Code:
```java
public boolean isSubtree(TreeNode root, TreeNode subRoot) {
		 if(root == null)
			 return false;
		 if(isSameTree(root, subRoot))
			 return true;
		 return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
	    }
	 public boolean isSameTree(TreeNode one, TreeNode two) {
		 if(one == null && two == null) {
			 return true;
		 }
		 if(one == null || two == null) {
			 return false;
		 }
		 if(one.val != two.val) {
			 return false;
		 }
		 return isSameTree(one.left, two.left) && isSameTree(one.right, two.right);
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