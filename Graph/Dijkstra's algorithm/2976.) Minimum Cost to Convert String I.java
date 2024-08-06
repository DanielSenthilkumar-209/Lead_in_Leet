/** 2976.) You are given two 0-indexed strings source and target, 

both of length n and consisting of lowercase English letters. 

You are also given two 0-indexed character arrays original and changed, and an integer array cost, 

where cost[i] represents the cost of changing the character original[i] to the character changed[i].

You start with the string source. 

In one operation, you can pick a character x from the string and change it to the character y at a cost of z 

if there exists any index j such that cost[j] == z, original[j] == x, and changed[j] == y.

Return the minimum cost to convert the string source to the string target using any number of operations. 

If it is impossible to convert source to target, return -1.

Note that there may exist indices i, j such that original[j] == original[i] and changed[j] == changed[i].


Example 1:

Input: source = "abcd", target = "acbe", original = ["a","b","c","c","e","d"], changed = ["b","c","b","e","b","e"], cost = [2,5,5,1,2,20]
Output: 28
Explanation: To convert the string "abcd" to string "acbe":
- Change value at index 1 from 'b' to 'c' at a cost of 5.
- Change value at index 2 from 'c' to 'e' at a cost of 1.
- Change value at index 2 from 'e' to 'b' at a cost of 2.
- Change value at index 3 from 'd' to 'e' at a cost of 20.
The total cost incurred is 5 + 1 + 2 + 20 = 28.
It can be shown that this is the minimum possible cost.

Example 2:

Input: source = "aaaa", target = "bbbb", original = ["a","c"], changed = ["c","b"], cost = [1,2]
Output: 12
Explanation: To change the character 'a' to 'b' change the character 'a' to 'c' at a cost of 1, followed by changing the character 'c' to 'b' at a cost of 2, for a total cost of 1 + 2 = 3. To change all occurrences of 'a' to 'b', a total cost of 3 * 4 = 12 is incurred.

Example 3:

Input: source = "abcd", target = "abce", original = ["a"], changed = ["e"], cost = [10000]
Output: -1
Explanation: It is impossible to convert source to target because the value at index 3 cannot be changed from 'd' to 'e'. **/








class Solution {
  public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
    long result = 0;
    int size = 26;
    long[][] distance = new long[size][size];
    
    for (long[] row : distance) {
      Arrays.fill(row, Long.MAX_VALUE);
    }
    
    for (int i = 0; i < cost.length; i++) {
      int o = original[i] - 'a';
      int c = changed[i] - 'a';
      distance[o][c] = Math.min(distance[o][c], cost[i]);
    }
    
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        if (distance[j][i] == Long.MAX_VALUE) 
           continue;
        for (int k = 0; k < size; k++) {
          if (distance[i][k] != Long.MAX_VALUE) {
            distance[j][k] = Math.min(distance[j][k], distance[j][i] + distance[i][k]);
          }
        }
      }
    }
    
    for (int i = 0; i < source.length(); i++) {
      if (source.charAt(i) != target.charAt(i)) {
        int o = source.charAt(i) - 'a';
        int c = target.charAt(i) - 'a';
        if (distance[o][c] == Long.MAX_VALUE) {
          return -1;
        }
        result += distance[o][c];
      }
    }
    return result;
  }
}