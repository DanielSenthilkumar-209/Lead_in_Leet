/** 1334.) There are n cities numbered from 0 to n-1. 

Given the array edges where edges[i] = [fromi, toi, weighti] represents a bidirectional and weighted edge between cities fromi and toi, 

and given the integer distanceThreshold.

Return the city with the smallest number of cities that are reachable through some path and whose distance is at most distanceThreshold, 

If there are multiple such cities, return the city with the greatest number.

Notice that the distance of a path connecting cities i and j is equal to the sum of the edges' weights along that path. 

Example 1:

Input: n = 4, edges = [[0,1,3],[1,2,1],[1,3,4],[2,3,1]], distanceThreshold = 4
Output: 3
Explanation: The figure above describes the graph. 
The neighboring cities at a distanceThreshold = 4 for each city are:
City 0 -> [City 1, City 2] 
City 1 -> [City 0, City 2, City 3] 
City 2 -> [City 0, City 1, City 3] 
City 3 -> [City 1, City 2] 
Cities 0 and 3 have 2 neighboring cities at a distanceThreshold = 4, but we have to return city 3 since it has the greatest number.

Example 2:

Input: n = 5, edges = [[0,1,2],[0,4,8],[1,2,3],[1,4,2],[2,3,1],[3,4,1]], distanceThreshold = 2
Output: 0
Explanation: The figure above describes the graph. 
The neighboring cities at a distanceThreshold = 2 for each city are:
City 0 -> [City 1] 
City 1 -> [City 0, City 4] 
City 2 -> [City 3, City 4] 
City 3 -> [City 2, City 4]
City 4 -> [City 1, City 2, City 3] 
The city 0 has 1 neighboring city at a distanceThreshold = 2. **/







class Solution {
  public int findTheCity(int n, int[][] edges, int distanceThreshold) {
    int result = -1;
    int min_cities = n;
    int[][] distance = floydWarshall(n, edges, distanceThreshold);

    for (int i = 0; i < n; i++) {
      int cities = 0;
      for (int j = 0; j < n; j++){
        if (distance[i][j] <= distanceThreshold)
          cities++;
      }
      if (cities <= min_cities) {
        result = i;
        min_cities = cities;
      }
    }
    return result;
  }

  int[][] floydWarshall(int n, int[][] edges, int distanceThreshold) {
    int[][] distance = new int[n][n];
    Arrays.stream(distance).forEach(A -> Arrays.fill(A, distanceThreshold + 1));

    for (int i = 0; i < n; ++i)
      distance[i][i] = 0;

    for (int[] e : edges) {
      int start = e[0];
      int end = e[1];
      int weight = e[2];
      distance[start][end] = weight;
      distance[end][start] = weight;
    }

    for (int a = 0; a < n; a++)
      for (int b = 0; b < n; b++)
        for (int c = 0; c < n; c++)
          distance[b][c] = Math.min(distance[b][c], distance[b][a] + distance[a][c]);

    return distance;
  }
}