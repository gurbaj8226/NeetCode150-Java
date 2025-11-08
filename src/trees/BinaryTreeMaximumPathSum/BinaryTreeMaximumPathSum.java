package trees.BinaryTreeMaximumPathSum;

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

public class BinaryTreeMaximumPathSum {
	int maxSum = Integer.MIN_VALUE;

	public int max(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int leftSide = Math.max(max(root.left), 0);
		int rightSide = Math.max(max(root.right), 0);

		int currentPath = root.val + leftSide + rightSide;

		maxSum = Math.max(maxSum, currentPath);

		return root.val + Math.max(leftSide, rightSide);
	}

	public int maxPathSum(TreeNode root) {
		max(root);
		return maxSum;
	}
}
