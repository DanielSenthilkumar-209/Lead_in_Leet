/** 1190.) You are given a string s that consists of lower case English letters and brackets.

Reverse the strings in each pair of matching parentheses, starting from the innermost one.

Your result should not contain any brackets. 

Example 1:

Input: s = "(abcd)"
Output: "dcba"

Example 2:

Input: s = "(u(love)i)"
Output: "iloveu"
Explanation: The substring "love" is reversed first, then the whole string is reversed.

Example 3:

Input: s = "(ed(et(oc))el)"
Output: "leetcode"
Explanation: First, we reverse the substring "oc", then "etco", and finally, the whole string. **/






class Solution {
  public String reverseParentheses(String s) {
    StringBuilder sb = new StringBuilder();
    Deque<Integer> stack = new ArrayDeque<>();
    Map<Integer, Integer> pair = new HashMap<>();

    for (int i = 0; i < s.length(); ++i)
      if (s.charAt(i) == '(') {
        stack.push(i);
      } else if (s.charAt(i) == ')') {
        final int j = stack.pop();
        pair.put(i, j);
        pair.put(j, i);
      }

    for (int i = 0, d = 1; i < s.length(); i += d)
      if (s.charAt(i) == '(' || s.charAt(i) == ')') {
        i = pair.get(i);
        d = -d;
      } else {
        sb.append(s.charAt(i));
      }

    return sb.toString();
  }
}