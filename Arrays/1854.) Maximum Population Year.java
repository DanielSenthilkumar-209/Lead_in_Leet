/** 1854.) You are given a 2D integer array logs where each logs[i] = [birthi, deathi] 

indicates the birth and death years of the ith person.

The population of some year x is the number of people alive during that year. 

The ith person is counted in year x's population if x is in the inclusive range [birthi, deathi - 1]. 

Note that the person is not counted in the year that they die.

Return the earliest year with the maximum population.

Example 1:

Input: logs = [[1993,1999],[2000,2010]]
Output: 1993
Explanation: The maximum population is 1, and 1993 is the earliest year with this population.

Example 2:

Input: logs = [[1950,1961],[1960,1971],[1970,1981]]
Output: 1960
Explanation: 
The maximum population is 2, and it had happened in years 1960 and 1970.
The earlier year between them is 1960. **/







class Solution {
  public int maximumPopulation(int[][] logs) {
    int min_Year = 1950;
    int max_Year = 2050;
    int result = 0;
    int curr_Population = 0;
    int max_Population = 0;
    int[] p = new int[max_Year + 1];

    for (int[] l : logs) {
      int birth = l[0];
      int death = l[1];
      p[birth]++;
      p[death]--;
    }

    for (int year = min_Year; year <= max_Year; year++) {
      curr_Population += p[year];
      if (curr_Population > max_Population) {
        max_Population = curr_Population;
        result = year;
      }
    }
    return result;
  }
}