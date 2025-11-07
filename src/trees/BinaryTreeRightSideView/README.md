#Binary Tree Right Side View

**Category:** Trees (NeetCode)  

**Difficulty:** Medium  

**Time Complexity:** O(n)  

**Space Complexity:** O(h) — height of the tree  

#Problem Description:
Given the root of a binary tree, imagine you are standing on the right side of it. Return the values of the nodes you can see ordered from top to bottom.

#Approach:
- Uses **Breadth-First Search (BFS)** traversal with a **queue**.
- We add TreeNodes to the queue level by level of the tree, so the queue.size() indicates the length of each level. 
- We take the last integer of the queue, which would be the right-most value of the level, and add it to the answer list. 
- Add child nodes (left → right) to the queue.  
- Continue until all levels are processed.  

#Example:
**Input:**  
root = [1,2,3,null,5,null,4]

**Output:**  
[1,3,4]

**Explanation:**  
The rightmost nodes visible from each level are 1 (top), 3 (middle), and 4 (bottom).

#Java Code:
```java
public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        if (root == null) {
            return answer;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int levelSize = q.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode current = q.poll();
                if (i == levelSize - 1) {
                    answer.add(current.val);
                }
                if (current.left != null) {
                    q.add(current.left);
                }
                if (current.right != null) {
                    q.add(current.right);
                }
            }
        }
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