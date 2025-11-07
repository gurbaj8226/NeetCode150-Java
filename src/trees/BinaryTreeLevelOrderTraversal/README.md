#Binary Tree Level Order Traversal

**Category:** Trees (NeetCode)  

**Difficulty:** Medium  

**Time Complexity:** O(n)  

**Space Complexity:** O(h) — height of the tree  

#Problem Description:
Given the root of a binary tree, return the level order traversal of its nodes’ values (i.e., from left to right, level by level).

#Approach:
- Uses **recursion (DFS)** with an additional `level` parameter to group values by depth.  
- When the current level doesn’t exist in the array, create a new list for that index of the array.  
- Add the current node’s value to its corresponding level list.  
- Recursively call the function for the left and right child with `level + 1` to indicate that they are a part of the next level.  

#Example:
**Input:**  
root = [3,9,20,null,null,15,7]

**Output:**  
[[3],[9,20],[15,7]]

**Explanation:**  
The root 3 is at level 0, nodes 9 and 20 are at level 1, and 15 and 7 are at level 2.

#Java Code:
```java
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

    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
```