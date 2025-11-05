package trees.DiameterOfBinaryTree;

import java.io.PrintStream;

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