/** 959.) An n x n grid is composed of 1 x 1 squares where each 1 x 1 square consists of a '/', '\', or blank space ' '. 

These characters divide the square into contiguous regions.

Given the grid grid represented as a string array, return the number of regions.

Note that backslash characters are escaped, so a '\' is represented as '\\'.

Example 1:

Input: grid = [" /","/ "]
Output: 2

Example 2:

Input: grid = [" /","  "]
Output: 1

Example 3:

Input: grid = ["/\\","\\/"]
Output: 5
Explanation: Recall that because \ characters are escaped, "\\/" refers to \/, and "/\\" refers to /\. **/








class Solution {
  public int regionsBySlashes(String[] grid) {
    int size = grid.length;
    int[][] graph = new int[size * 3][size * 3];
    int result = 0;

    for (int i = 0; i < size; i++)
      for (int j = 0; j < size; j++)
        if (grid[i].charAt(j) == '/') {
          graph[i * 3][j * 3 + 2] = 1;
          graph[i * 3 + 1][j * 3 + 1] = 1;
          graph[i * 3 + 2][j * 3] = 1;
        } 
        else if (grid[i].charAt(j) == '\\') {
          graph[i * 3][j * 3] = 1;
          graph[i * 3 + 1][j * 3 + 1] = 1;
          graph[i * 3 + 2][j * 3 + 2] = 1;
        }
    for (int i = 0; i < size * 3; i++){
      for (int j = 0; j < size * 3; j++)
        if (graph[i][j] == 0) {
          dfs(graph, i, j);
          result++;
        }
    }
    return result;
  }

  void dfs(int[][] graph, int i, int j) {
    if (i < 0 || i == graph.length || j < 0 || j == graph[0].length)
      return;
    if (graph[i][j] != 0)
      return;
    graph[i][j] = 2; 
    dfs(graph, i + 1, j);
    dfs(graph, i - 1, j);
    dfs(graph, i, j + 1);
    dfs(graph, i, j - 1);
  }
}