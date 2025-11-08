package trees.ConstructBinaryTreeFromPreorderAndInorderTraversal;

import java.util.HashMap;
import java.util.Map;

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
