# Construct Binary Tree from Preorder and Inorder Traversal

**Category:** Binary Tree (NeetCode)  

**Difficulty:** Medium  

**Time Complexity:** O(n)  

**Space Complexity:** O(n)

## Problem Description:
Given two integer arrays `preorder` and `inorder` where `preorder` is the preorder traversal of a binary tree and `inorder` is the inorder traversal of the same tree, construct and return the binary tree.

## Approach:
- The first element in the preorder array is always the root node.
- Use a HashMap to store each value’s index of the inorder array.
- Use recursion to build the tree. Once you obtain the root node from the preorder array, you can find the left subtree in the inorder array by getting rootvalue from the hash map and subtracting one. 
- You can do the same thing for the right subtree but adding one instead. The stop condition is when left > right. 

## Example:
**Input:**  
`preorder = [3,9,20,15,7]`  
`inorder = [9,3,15,20,7]`

**Output:**  
Binary Tree = `[3,9,20,null,null,15,7]`

**Explanation:**  
- Root = 3  
- Left Subtree = [9]  
- Right Subtree = [20,15,7]

## Java Code:
```java
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
	int index;
	Map<Integer, Integer> inOrderMap;

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		index = 0;
		inOrderMap = new HashMap<>();
		for (int i = 0; i < inorder.length; i++) {
			inOrderMap.put(inorder[i], i);
		}
		return arrayToTree(preorder, 0, preorder.length - 1);
	}

	public TreeNode arrayToTree(int[] preorder, int left, int right) {
		if (left > right)
			return null;

		int rootValue = preorder[index++];

		TreeNode root = new TreeNode(rootValue);
		root.left = arrayToTree(preorder, left, inOrderMap.get(rootValue) - 1);
		root.right = arrayToTree(preorder, inOrderMap.get(rootValue) + 1, right);
		return root;
	}
}