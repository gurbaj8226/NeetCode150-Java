package trees.BinaryTreeLevelOrderTraversal;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {
	List<List<Integer>> answer = new ArrayList<>();

	public void Order(TreeNode root, int level) {
		if (answer.size() == level) {
			answer.add(new ArrayList<Integer>());
		}
		answer.get(level).add(root.val);
		if (root.left != null) {
			Order(root.left, level + 1);
		}
		if (root.right != null) {
			Order(root.right, level + 1);
		}
	}

	public List<List<Integer>> levelOrder(TreeNode root) {
		if (root == null) {
			return answer;
		}
		Order(root, 0);
		return answer;
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