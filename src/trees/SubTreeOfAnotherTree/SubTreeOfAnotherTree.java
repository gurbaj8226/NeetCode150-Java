package trees.SubTreeOfAnotherTree;

public class SubTreeOfAnotherTree {
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