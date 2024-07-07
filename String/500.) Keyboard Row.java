/** 500.) Given an array of strings words,  return the words that can be typed using letters of the alphabet 
on only one row of American keyboard like the image below.

In the American keyboard:

the first row consists of the characters "qwertyuiop",
the second row consists of the characters "asdfghjkl", and
the third row consists of the characters "zxcvbnm".

Example 1:

Input: words = ["Hello","Alaska","Dad","Peace"]
Output: ["Alaska","Dad"]

Example 2:

Input: words = ["omk"]
Output: []

Example 3:

Input: words = ["adsdf","sfd"]
Output: ["adsdf","sfd"] **/







class Solution {
  public String[] findWords(String[] words) {
    List<String> ans = new ArrayList<>();
    final int[] rows = {2, 3, 3, 2, 1, 2, 2, 2, 1, 2, 2, 2, 3,
                        3, 1, 1, 1, 1, 2, 1, 1, 3, 1, 3, 1, 3};

    for (final String word : words) {
      final String lowerWord = word.toLowerCase();
      final int row = rows[lowerWord.charAt(0) - 'a'];
      final boolean isValid = lowerWord.chars().allMatch(c -> rows[c - 'a'] == row);
      if (isValid)
        ans.add(word);
    }

    return ans.toArray(new String[0]);
  }
}