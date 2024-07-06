/** 4.) Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).

Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.
Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5. **/



class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[] mergedArray = new int[n1 + n2];
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < n1 && j < n2) {
            if (nums1[i] < nums2[j]) {
                mergedArray[k++] = nums1[i++];
            } else {
                mergedArray[k++] = nums2[j++];
            }
        }

        while (i < n1) {
            mergedArray[k++] = nums1[i++];
        }

        while (j < n2) {
            mergedArray[k++] = nums2[j++];
        }

        if ((n1 + n2) % 2 == 0) {
            return (mergedArray[(n1 + n2) / 2 - 1] + mergedArray[(n1 + n2) / 2]) / 2.0;
        } else {
            return mergedArray[(n1 + n2) / 2];
        }
    }
}