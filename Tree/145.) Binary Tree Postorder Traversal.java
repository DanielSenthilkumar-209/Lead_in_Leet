/** 145.) Given the root of a binary tree, return the postorder traversal of its nodes' values.

Example 1:

Input: root = [1,null,2,3]
Output: [3,2,1]

Example 2:

Input: root = []
Output: []

Example 3:

Input: root = [1]
Output: [1] **/





class Solution {
  public List<Integer> postorderTraversal(TreeNode root) {

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
    
  if (root == null)
      return new ArrayList<>();

    List<Integer> ans = new ArrayList<>();
    Deque<TreeNode> stack = new ArrayDeque<>();
    stack.push(root);

    while (!stack.isEmpty()) {
      root = stack.pop();
      ans.add(root.val);
      if (root.left != null)
        stack.push(root.left);
      if (root.right != null)
        stack.push(root.right);
    }

    Collections.reverse(ans);
    return ans;
  }
}