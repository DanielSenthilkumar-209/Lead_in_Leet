/** 273.) Convert a non-negative integer num to its English words representation.


Example 1:

Input: num = 123
Output: "One Hundred Twenty Three"

Example 2:

Input: num = 12345
Output: "Twelve Thousand Three Hundred Forty Five"

Example 3:

Input: num = 1234567
Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven" **/







class Solution {
  public String numberToWords(int num) {
    return num == 0 ? "Zero" : englishWords(num);
  }

  // Arrays to store words for numbers from 1 to 19 and multiples of ten.
  
  String[] oneToTwenty = {"", "One", "Two", "Three", "Four", "Five",        "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen","Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

  String[] multipleOfTens = {"",      "",      "Twenty",  "Thirty", "Forty",
"Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

  // Helper method to convert numbers to words and 
  // StringBuilder to construct the word representation of the number.

  String englishWords(int num) {
    StringBuilder sb = new StringBuilder();

    // For numbers less than 20.
    if (num < 20)
      sb.append(oneToTwenty[num]);
    // For numbers less than 100.
    else if (num < 100)
      sb.append(multipleOfTens[num / 10]).append(" ").append(oneToTwenty[num % 10]);
    // For numbers less than 1000.  
    else if (num < 1000)
      sb.append(englishWords(num / 100)).append(" Hundred ").append(englishWords(num % 100));
    // For numbers less than 1,000,000.
    else if (num < 1000000)
      sb.append(englishWords(num / 1000)).append(" Thousand ").append(englishWords(num % 1000));
    // For numbers less than 1,000,000,000.
    else if (num < 1000000000)
      sb.append(englishWords(num / 1000000)).append(" Million ").append(englishWords(num % 1000000));
    // For numbers above 1,000,000,000.
    else
      sb.append(englishWords(num / 1000000000)).append(" Billion ").append(englishWords(num % 1000000000));
    // Returning the final string of english words.
    return sb.toString().trim();
  }
}