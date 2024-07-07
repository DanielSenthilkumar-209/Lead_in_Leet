/** 1189.) Given a string text, you want to use the characters of text to form as many instances of the word "balloon" as possible.

You can use each character in text at most once. Return the maximum number of instances that can be formed.

Example 1:

Input: text = "nlaebolko"
Output: 1

Example 2:

Input: text = "loonbalxballpoon"
Output: 2

Example 3:

Input: text = "leetcode"
Output: 0 **/







class Solution {
  public int maxNumberOfBalloons(String text) {
    int ans = Integer.MAX_VALUE;
    int[] count = new int[26];

    for (char c : text.toCharArray())
      ++count[c - 'a'];

    for (char c : new char[] {'b', 'a', 'n'})
      ans = Math.min(ans, count[c - 'a']);

    for (char c : new char[] {'o', 'l'})
      ans = Math.min(ans, count[c - 'a'] / 2);

    return ans;
  }
}