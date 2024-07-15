/** 2196.) You are given a 2D integer array descriptions where descriptions[i] = [parent[i], child[i], isLeft[i]] 

indicates that parenti is the parent of child[i] in a binary tree of unique values. 

Furthermore,

If isLefti == 1, then childi is the left child of parenti.

If isLefti == 0, then childi is the right child of parenti.

Construct the binary tree described by descriptions and return its root.

The test cases will be generated such that the binary tree is valid.

Example 1:

Input: descriptions = [[20,15,1],[20,17,0],[50,20,1],[50,80,0],[80,19,1]]

Output: [50,20,80,15,17,19]

Explanation: The root node is the node with value 50 since it has no parent.
The resulting binary tree is shown in the diagram.

Example 2:

Input: descriptions = [[1,2,1],[2,3,0],[3,4,1]]

Output: [1,2,null,null,3,4]

Explanation: The root node is the node with value 1 since it has no parent.
The resulting binary tree is shown in the diagram. **/






class Solution {
  public TreeNode createBinaryTree(int[][] descriptions) {
    Map<TreeNode, TreeNode> child_Parent = new HashMap<>();
    Map<Integer, TreeNode> value_Node = new HashMap<>();

    for (int[] desc : descriptions) {
      int p = desc[0];
      int c = desc[1];
      int l = desc[2];
      TreeNode parent = value_Node.getOrDefault(p, new TreeNode(p));
      value_Node.put(p, parent);
      TreeNode child = value_Node.getOrDefault(c, new TreeNode(c));
      value_Node.put(c, child);
      child_Parent.put(child, parent);
      if (l == 1)
        parent.left = child;
      else
        parent.right = child;
    }

    TreeNode root = child_Parent.keySet().iterator().next();
    while (child_Parent.containsKey(root))
      root = child_Parent.get(root);
    return root;
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