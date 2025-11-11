# Kth Smallest Element in a BST

**Category:** Trees (NeetCode)  

**Difficulty:** Medium  

**Time Complexity:** O(n)  

**Space Complexity:** O(h), where h is the tree height

## Problem Description
Given the root of a binary search tree and an integer `k`, return the `k-th` smallest value (1-indexed) of all the values in the tree.

## Approach
* Use an **in-order traversal** (left → root → right) which naturally visits BST nodes in sorted order.  
* Maintain a counter as you traverse.  
* When the counter equals `k`, store and return the current node’s value.

This approach uses recursion and global variables for simplicity.

## Example
**Input:**  
root = [3,1,4,null,2], k = 1

**Output:**  
`1`

**Explanation:**  
The inorder traversal yields `[1,2,3,4]`. The 1st smallest element is `1`.

## Java Code
```java
public class KthSmallestElementInBST {
	class Solution {
	    int count;
	    int result;
	    public int kthSmallest(TreeNode root, int k) {
	        count = 0;
	        result = 0;
	        smallest(root, k);
	        return result;
	       
	    }
	    public void smallest(TreeNode root, int k){
	        if(root == null){
	            return;
	        }
	        smallest(root.left, k);
	        count++;
	        if(count == k){
	            result = root.val;
	            return;
	        }
	        smallest(root.right, k);
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
}

---