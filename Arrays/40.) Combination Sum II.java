/** 40.) Given a collection of candidate numbers (candidates) and a target number (target), 

find all unique combinations in candidates where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.

Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8
Output: 
[ [1,1,6], [1,2,5], [1,7], [2,6] ]

Example 2:

Input: candidates = [2,5,2,1,2], target = 5
Output: 
[ [1,2,2], [5] ] **/








class Solution {
  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(candidates);
    dfs(0, candidates, target, new ArrayList<>(), result);
    return result;
  }

  void dfs(int s, int[] candidates, int target, List<Integer> path, List<List<Integer>> result) {
    if (target < 0)
      return;
    if (target == 0) {
      result.add(new ArrayList<>(path));
      return;
    }

    for (int i = s; i < candidates.length; ++i) {
      if (i > s && candidates[i] == candidates[i - 1])
        continue;
      path.add(candidates[i]);
      dfs(i + 1, candidates, target - candidates[i], path, result);
      path.remove(path.size() - 1);
    }
  }
}