/** 624.) You are given m arrays, where each array is sorted in ascending order.

You can pick up two integers from two different arrays (each array picks one) and calculate the distance. 

We define the distance between two integers a and b to be their absolute difference |a - b|.

Return the maximum distance.

Example 1:

Input: arrays = [[1,2,3],[4,5],[1,2,3]]
Output: 4
Explanation: One way to reach the maximum distance 4 is to pick 1 in the first or third array and pick 5 in the second array.

Example 2:

Input: arrays = [[1],[1]]
Output: 0 **/








class Solution {
  public int maxDistance(List<List<Integer>> arrays) {
    int result = 0;
    int min = 10000;
    int max = -10000;

    for (List<Integer> l : arrays) {
      result = Math.max(result, Math.max(l.get(l.size() - 1) - min, max - l.get(0)));
      min = Math.min(min, l.get(0));
      max = Math.max(max, l.get(l.size() - 1));
    }

    return result;
  }
}