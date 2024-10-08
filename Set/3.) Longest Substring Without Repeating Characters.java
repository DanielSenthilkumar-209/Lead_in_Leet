/** 3.) Given a string s, find the length of the longest substring
 without repeating characters. 

Example 1:

Input: s = "abcabcbb"

Output: 3

Explanation: The answer is "abc", with the length of 3.

Example 2:

Input: s = "bbbbb"

Output: 1

Explanation: The answer is "b", with the length of 1.

Example 3:

Input: s = "pwwkew"

Output: 3

Explanation: The answer is "wke", with the length of 3.

Notice that the answer must be a substring, "pwke" is a subsequence and not a substring. **/







class Solution {
    public int lengthOfLongestSubstring(String s) {
        int a_pointer = 0;
        int b_pointer = 0;
        int max = 0;
        HashSet<Character> hash_set = new HashSet <>();
        while(b_pointer < s.length())
        {
            if (!hash_set.contains(s.charAt(b_pointer)))
            {
                hash_set.add(s.charAt(b_pointer));
                b_pointer++;
                max = Math.max(hash_set.size(),max);
            }
            else
            {
                hash_set.remove(s.charAt(a_pointer));
                a_pointer++;
            }
        }
        return max;
    }
}