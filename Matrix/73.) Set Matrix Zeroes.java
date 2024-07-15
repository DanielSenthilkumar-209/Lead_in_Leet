/** 73.) Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.

You must do it in place.

Example 1:

Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]

Output: [[1,0,1],[0,0,0],[1,0,1]]

Example 2:

Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]

Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]] **/






class Solution {
    public void setZeroes(int[][] matrix) {
        final int m = matrix.length;
        final int n = matrix[0].length;
        boolean shouldFillFirstRow = false;
        boolean shouldFillFirstCol = false;

        for(int i = 0; i < m; ++i)
           if(matrix[i][0] == 0)
           {
               shouldFillFirstCol = true;
               break;
           }
        for(int j = 0; j < n; ++j)
           if(matrix[0][j] == 0)
           {
               shouldFillFirstRow = true;
               break;
           }
        for(int i = 1; i < m; ++i)
           for(int j = 1; j < n;++j)
              if(matrix[i][j] == 0)
              {
                  matrix[i][0] = 0;
                  matrix[0][j] = 0;
              }
        for(int i = 1; i < m; ++i)
           for(int j = 1; j < n; ++j)
              if(matrix[i][0] == 0 || matrix[0][j] == 0)
                matrix[i][j] = 0;

        if(shouldFillFirstCol)
          for(int i = 0; i < m; ++i)
             matrix[i][0] = 0;

        if(shouldFillFirstRow)
          for(int j = 0; j < n; ++j)
             matrix[0][j] = 0;
    }
}