package trees.KthSmallestElementInBST;

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
