/** 95.) Given an integer n, return all the structurally unique BST's (binary search trees), 

which has exactly n nodes of unique values from 1 to n. 

Return the answer in any order.

Example 1:

Input: n = 3
Output: [[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]

Example 2:

Input: n = 1
Output: [[1]] **/





class Solution {
    public List<TreeNode> generateTrees(int n) {
        return helper(1,n);
    }
    List<TreeNode> helper(int start,int end)
    {     
        List<TreeNode> list = new ArrayList<>();
        if(start > end)
        {
             list.add(null);
             return list;
        }
        if(start == end)
        {
             list.add(new TreeNode(start));
             return list;
        }
        for(int i = start; i <= end; i++)
        {
            List<TreeNode> leftPossibleTrees = helper(start, i-1);
            List<TreeNode> rightPossibleTrees = helper(i+1,end);
            for(TreeNode lRoot : leftPossibleTrees)
            {
                for(TreeNode rRoot : rightPossibleTrees)
                {
                    TreeNode root = new TreeNode(i);
                    root.left = lRoot;
                    root.right = rRoot;
                    list.add(root);
                }
            }
        }
        return list;
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
