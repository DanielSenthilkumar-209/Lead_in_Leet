/** 1351.) Given a m x n matrix grid which is sorted in non-increasing order both row-wise and column-wise, 

return the number of negative numbers in grid.

 

Example 1:

Input: grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
Output: 8
Explanation: There are 8 negatives number in the matrix.

Example 2:

Input: grid = [[3,2],[1,0]]
Output: 0**/






class Solution {
  public int countNegatives(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    int result = 0;
    int i = m - 1;
    int j = 0;

    while (i >= 0 && j < n) {
      if (grid[i][j] < 0) {
        result += n - j;
        i--;
      } 
      else {
        j++;
      }
    }
    return result;
  }
}