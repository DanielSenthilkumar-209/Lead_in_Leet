/** 2058.) A critical point in a linked list is defined as either a local maxima or a local minima.

A node is a local maxima if the current node has a value strictly greater than the previous node and the next node.

A node is a local minima if the current node has a value strictly smaller than the previous node and the next node.

Note that a node can only be a local maxima/minima if there exists both a previous node and a next node.

Given a linked list head, return an array of length 2 containing [minDistance, maxDistance] where 

minDistance is the minimum distance between any two distinct critical points and 

maxDistance is the maximum distance between any two distinct critical points. 

If there are fewer than two critical points, return [-1, -1].

Example 1:
Input: head = [3,1]
Output: [-1,-1]
Explanation: There are no critical points in [3,1].

Example 2:
Input: head = [5,3,1,2,5,1,2]
Output: [1,3]
Explanation: There are three critical points:
- [5,3,1,2,5,1,2]: The third node is a local minima because 1 is less than 3 and 2.
- [5,3,1,2,5,1,2]: The fifth node is a local maxima because 5 is greater than 2 and 1.
- [5,3,1,2,5,1,2]: The sixth node is a local minima because 1 is less than 5 and 2.
The minimum distance is between the fifth and the sixth node. minDistance = 6 - 5 = 1.
The maximum distance is between the third and the sixth node. maxDistance = 6 - 3 = 3.

Example 3:
Input: head = [1,3,2,2,3,2,2,2,7]
Output: [3,3]
Explanation: There are two critical points:
- [1,3,2,2,3,2,2,2,7]: The second node is a local maxima because 3 is greater than 1 and 2.
- [1,3,2,2,3,2,2,2,7]: The fifth node is a local maxima because 3 is greater than 2 and 2.
Both the minimum and maximum distances are between the second and the fifth node.
Thus, minDistance and maxDistance is 5 - 2 = 3.
Note that the last node is not considered a local maxima because it does not have a next node. **/







class Solution {
  public int[] nodesBetweenCriticalPoints(ListNode head) {
    int minimum_distance = Integer.MAX_VALUE;
    int first_max_index = -1;
    int prev_max_index = -1;
    int index = 1;
    ListNode previous = head;      
    ListNode current = head.next; 

    while (current.next != null) {
      if (current.val > previous.val && current.val > current.next.val ||
          current.val < previous.val && current.val < current.next.val) {
        if (first_max_index == -1) 
          first_max_index = index;
        if (prev_max_index != -1)
          minimum_distance = Math.min(minimum_distance, index - prev_max_index);
        prev_max_index = index;
      }
      previous = current;
      current = current.next;
      index++;
    }
    if (minimum_distance == Integer.MAX_VALUE)
      return new int[] {-1, -1};
    return new int[] {minimum_distance, prev_max_index - first_max_index};
  }
}