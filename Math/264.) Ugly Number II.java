/** 264.) An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.

Given an integer n, return the nth ugly number. 

Example 1:

Input: n = 10
Output: 12
Explanation: [1, 2, 3, 4, 5, 6, 8, 9, 10, 12] is the sequence of the first 10 ugly numbers.

Example 2:

Input: n = 1
Output: 1
Explanation: 1 has no prime factors, therefore all of its prime factors are limited to 2, 3, and 5. **/









class Solution {
  public int nthUglyNumber(int n) {
    ArrayList<Integer> uglyNumbers = new ArrayList<>();
    uglyNumbers.add(1);
    int i2 = 0;
    int i3 = 0;
    int i5 = 0;

    while (uglyNumbers.size() < n) {
      int next2 = uglyNumbers.get(i2) * 2;
      int next3 = uglyNumbers.get(i3) * 3;
      int next5 = uglyNumbers.get(i5) * 5;
      int next = Math.min(next2, Math.min(next3, next5));
      if (next == next2)
        i2++;
      if (next == next3)
        i3++;
      if (next == next5)
        i5++;
      uglyNumbers.add(next);
    }
    return uglyNumbers.get(uglyNumbers.size() - 1);
  }
}