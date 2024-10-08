/** 3120.) You are given a string word. 

A letter is called special if it appears both in lowercase and uppercase in word.

Return the number of special letters in word.

Example 1:

Input: word = "aaAbcBC"

Output: 3

Explanation: The special characters in word are 'a', 'b', and 'c'.

Example 2:

Input: word = "abc"

Output: 0

Explanation: No character in word appears in uppercase.

Example 3:

Input: word = "abBCab"

Output: 1

Explanation: The only special character in word is 'b'. **/









class Solution {
  public int numberOfSpecialChars(String word) {
    int result = 0;
    boolean[] low = new boolean[26];
    boolean[] up = new boolean[26];

    for (char c : word.toCharArray()){
      if (Character.isLowerCase(c))
        low[c - 'a'] = true;
      else
        up[c - 'A'] = true;
    }
    for (int i = 0; i < 26; i++){
      if (low[i] && up[i])
        result++;
    }
    return result;
  }
}