/** 1717.) You are given a string s and two integers x and y. 

You can perform two types of operations any number of times.

Remove substring "ab" and gain x points.

For example, when removing "ab" from "cabxbae" it becomes "cxbae".

Remove substring "ba" and gain y points.

For example, when removing "ba" from "cabxbae" it becomes "cabxe".

Return the maximum points you can gain after applying the above operations on s.

Example 1:

Input: s = "cdbcbbaaabab", x = 4, y = 5
Output: 19
Explanation:
- Remove the "ba" underlined in "cdbcbbaaabab". Now, s = "cdbcbbaaab" and 5 points are added to the score.
- Remove the "ab" underlined in "cdbcbbaaab". Now, s = "cdbcbbaa" and 4 points are added to the score.
- Remove the "ba" underlined in "cdbcbbaa". Now, s = "cdbcba" and 5 points are added to the score.
- Remove the "ba" underlined in "cdbcba". Now, s = "cdbc" and 5 points are added to the score.
Total score = 5 + 4 + 5 + 5 = 19.

Example 2:

Input: s = "aabbaaxybbaabb", x = 5, y = 4
Output: 20 **/







class Solution {
  public int maximumGain(String s, int x, int y) {
    if(x > y){
        return gain(s, "ab", x, "ba", y);
    }
    else{
        return gain(s, "ba", y, "ab", x);
    }
  }

  int gain(String s, String s1, int xPoints, String s2, int yPoints) {
    int points = 0;
    Stack<Character> stk1 = new Stack<>();
    Stack<Character> stk2 = new Stack<>();

    for (char c : s.toCharArray())
      if (!stk1.isEmpty() && stk1.peek() == s1.charAt(0) && c == s1.charAt(1)) {
        stk1.pop();
        points += xPoints;
      } 
      else {
        stk1.push(c);
      }

    for (char c : stk1)
      if (!stk2.isEmpty() && stk2.peek() == s2.charAt(0) && c == s2.charAt(1)) {
        stk2.pop();
        points += yPoints;
      } 
      else {
        stk2.push(c);
      }
    return points;
  }
}