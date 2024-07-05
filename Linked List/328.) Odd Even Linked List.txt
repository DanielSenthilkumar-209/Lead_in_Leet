/** 328.) Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.

The first node is considered odd, and the second node is even, and so on.

Note that the relative order inside both the even and odd groups should remain as it was in the input.

You must solve the problem in O(1) extra space complexity and O(n) time complexity.

Example 1:

Input: head = [1,2,3,4,5]
Output: [1,3,5,2,4]

Example 2:

Input: head = [2,1,3,5,6,4,7]
Output: [2,3,6,7,1,5,4] **/





class Solution {
  public ListNode oddEvenList(ListNode head) {
    ListNode odd_head = new ListNode(0);
    ListNode even_head = new ListNode(0);
    ListNode o = odd_head;
    ListNode e = even_head;

    for (boolean is_odd = true; head != null; head = head.next, is_odd = !is_odd)
      if (is_odd) {
        o.next = head;
        o = o.next;
      } else {
        e.next = head;
        e = e.next;
      }

    o.next = even_head.next;
    e.next = null;
    return odd_head.next;
  }
}