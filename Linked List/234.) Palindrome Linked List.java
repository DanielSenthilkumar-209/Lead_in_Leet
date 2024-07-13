/** 234.) Given the head of a singly linked list, return true if it is a palindrome or false otherwise.

Example 1:

Input: head = [1,2,2,1]
Output: true

Example 2:

Input: head = [1,2]
Output: false **/






class Solution {
  public boolean isPalindrome(ListNode head) {
    ListNode s = head;
    ListNode f = head;

    while (f != null && f.next != null) {
      s = s.next;
      f = f.next.next;
    }

    if (f != null)
      s = s.next;
    s = reverseList(s);

    while (s != null) {
      if (s.val != head.val)
        return false;
      s = s.next;
      head = head.next;
    }
    return true;
  }

  ListNode reverseList(ListNode head) {
    ListNode prev = null;

    while (head != null) {
      ListNode next = head.next;
      head.next = prev;
      prev = head;
      head = next;
    }
    return prev;
  }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */