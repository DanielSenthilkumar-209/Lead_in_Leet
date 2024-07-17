/** 96.) Given an integer n, return the number of structurally unique BST's (binary search trees) 

which has exactly n nodes of unique values from 1 to n.

Example 1:

Input: n = 3
Output: 5

Example 2:

Input: n = 1
Output: 1 **/





class Solution {
    Integer [] cache;
    public int numTrees(int n) {
        cache = new Integer[n+1];
        return dfs(n);
    }
    private int dfs(int n)
    {
        if(n<2) return 1;

        if(cache[n] != null) return cache[n];

        int total =0;
        for(int curNum = 1;curNum <= n; curNum++)
        {
            int leftN = curNum - 1;
            int leftTotalBST = dfs(leftN);
            int rightN = n - curNum;
            int rightTotalBST = dfs(rightN);
            total += (leftTotalBST * rightTotalBST);
        }
        cache[n] = total;
        return total;
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