/** Given a string containing digits from 2-9 inclusive, 

return all possible letter combinations that the number could represent. 

Return the answer in any order.

A mapping of digits to letters (just like on the telephone buttons) is given below. 

Note that 1 does not map to any letters.

Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

Example 2:

Input: digits = ""
Output: []

Example 3:

Input: digits = "2"
Output: ["a","b","c"] **/






class Solution {
    public List<String> letterCombinations(String digits) {
        LinkedList<String> out_array = new LinkedList<>();
        if(digits.length() == 0) return out_array;
        out_array.add("");

        String[] charmap = new String[] {"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        for(int i = 0; i < digits.length(); i++)
        {
            int index = Character.getNumericValue(digits.charAt(i));
            while(out_array.peek().length() == i)
            {
                 String permutation = out_array.remove();
                 for(char c : charmap[index].toCharArray())
                 {
                    out_array.add(permutation + c);
                 }
            }
        }
        return out_array;
    }
}