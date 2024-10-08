/** 1110.) Given the root of a binary tree, each node in the tree has a distinct value.

After deleting all nodes with a value in to_delete, we are left with a forest (a disjoint union of trees).

Return the roots of the trees in the remaining forest. You may return the result in any order.

Example 1:

Input: root = [1,2,3,4,5,6,7], to_delete = [3,5]
Output: [[1,2,null,4],[6],[7]]

Example 2:

Input: root = [1,2,4,null,3], to_delete = [3]
Output: [[1,2,4]] **/





class Solution {
  public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
    List<TreeNode> result = new ArrayList<>();
    Set<Integer> to_deleteSet = Arrays.stream(to_delete).boxed().collect(Collectors.toSet());
    dfs(root, to_deleteSet, true, result);
    return result;
  }

  private TreeNode dfs(TreeNode root, Set<Integer> to_deleteSet, boolean isRoot, List<TreeNode> result) {
    if (root == null)
      return null;

    final boolean deleted = to_deleteSet.contains(root.val);
    if (isRoot && !deleted)
      result.add(root);
    root.left = dfs(root.left, to_deleteSet, deleted, result);
    root.right = dfs(root.right, to_deleteSet, deleted, result);
    return deleted ? null : root;
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