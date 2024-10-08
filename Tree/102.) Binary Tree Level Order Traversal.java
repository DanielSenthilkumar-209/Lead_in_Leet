/** 102.) Given the root of a binary tree, return the level order traversal of its nodes' values. 

(i.e., from left to right, level by level).

Example 1:

Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]

Example 2:

Input: root = [1]
Output: [[1]]

Example 3:

Input: root = []
Output: [] **/





class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
        result = new ArrayList<>();
        if(root == null) return result;
        
        traverse(root,0);
        return result;
    }
    private void traverse(TreeNode node, int level)
    {
        if(node == null) return;
        if(result.size() == level)
        {
            result.add(new ArrayList<>());
        }
        result.get(level).add(node.val);
        traverse(node.left,level+1);
        traverse(node.right,level+1);
    }
}

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