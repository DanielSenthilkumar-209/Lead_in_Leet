/** 912.) Given an array of integers nums, sort the array in ascending order and return it.

You must solve the problem without using any built-in functions in O(nlog(n)) time complexity

 and with the smallest space complexity possible.

Example 1:

Input: nums = [5,2,3,1]
Output: [1,2,3,5]
Explanation: After sorting the array, the positions of some numbers are not changed (for example, 2 and 3), 
while the positions of other numbers are changed (for example, 1 and 5).

Example 2:

Input: nums = [5,1,1,2,0,0]
Output: [0,0,1,1,2,5]
Explanation: Note that the values of nums are not necessairly unique. **/






class Solution {
  public int[] sortArray(int[] nums) {
    mergeSort(nums, 0, nums.length - 1);
    return nums;
  }

  void mergeSort(int[] array, int left, int right) {
    if (left >= right){
      return;
    }
    int middle = (left + right) / 2;
    mergeSort(array, left, middle);
    mergeSort(array, middle + 1, right);
    merge(array, left, right, middle);
  }

  void merge(int[] array, int left, int right, int middle) {
    int[] sorted_array = new int[right - left + 1];
    int i = 0;     // sorted_array index
    int j = left;     // left side index
    int k = middle + 1; // right side index

    while (j <= middle && k <= right){
      if (array[j] < array[k]){
        sorted_array[i++] = array[j++];
      }
      else{
        sorted_array[i++] = array[k++];
      }
    }
    // Placing the remaining left side into the sorted_array.
    while (j <= middle)
      sorted_array[i++] = array[j++];

    // Placing the remaining right side into the sorted_array.
    while (k <= right)
      sorted_array[i++] = array[k++];

    // Copying the elements from the sorted_array[] into array[] from the 
    // left side's index till the length of the sorted_array[]. 
    System.arraycopy(sorted_array, 0, array, left, sorted_array.length);
  }
}