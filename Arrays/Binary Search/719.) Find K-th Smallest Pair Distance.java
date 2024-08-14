/** 719.) The distance of a pair of integers a and b is defined as the absolute difference between a and b.

Given an integer array nums and an integer k, 

return the kth smallest distance among all the pairs nums[i] and nums[j] where 0 <= i < j < nums.length.

Example 1:

Input: nums = [1,3,1], k = 1
Output: 0
Explanation: Here are all the pairs:
(1,3) -> 2
(1,1) -> 0
(3,1) -> 2
Then the 1st smallest distance pair is (1,1), and its distance is 0.

Example 2:

Input: nums = [1,1,1], k = 2
Output: 0

Example 3:

Input: nums = [1,6,1], k = 3
Output: 5 **/







class Solution {
  public int smallestDistancePair(int[] nums, int k) {
    Arrays.sort(nums);
    int left = 0;
    int right = nums[nums.length - 1] - nums[0];

    while (left < right) {
      int middle = (left + right) / 2;
      if (numPairDistancesNotGreaterThan(nums, middle) >= k)
        right = middle;
      else
        left = middle + 1;
    }
    return left;
  }

  int numPairDistancesNotGreaterThan(int[] nums, int middle) {
    int count = 0;
    int j = 1;
    // For each index i, find the first index j s.t. nums[j] > nums[i] + m,
    // so numPairDistancesNoGreaterThan for the index i will be j - i - 1.
    for (int i = 0; i < nums.length; i++) {
      while (j < nums.length && nums[j] <= nums[i] + middle)
        j++;
      count += j - i - 1;
    }
    return count;
  }
}