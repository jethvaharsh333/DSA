package RECURSION_AND_BACKTRACKING.RECURSION.AAT_Special_Binary_String;

import java.util.*;

/**
 * Question link:
 * Date: 17-07-2025
 * Time complexity:
 * Space complexity:
 */

public class Solution {
    public String makeLargestSpecial(String s) {
        if(s.length() <= 2) return s;

        List<String> specials = new ArrayList<>();
        int count=0, start=0;

        for(int i=0 ; i<s.length() ; i++){
            count += s.charAt(i) == '1' ? 1 : -1;

            if(count == 0){
                String inner = s.substring(start+1, i);
                specials.add("1" + makeLargestSpecial(inner) + "0");
                start = i+1;
            }
        }

        specials.sort((a, b) -> b.compareTo(a));
        return String.join("", specials);
    }
}

/*

Question: There will be more operations of swapping. In which we have to swap two consecutive subtsring so that it is lexicographically larger decimal than before.

lexicographically larger => Just compare characters from left to right. The first character that is different decides which string is bigger.
For example: "11100100" is lexicographically larger than "11011000"
                Even though in binary:
                    => 11100100 = 228
                    => 11011000 = 216
STILL, the output is judged not by numeric value, but by string comparison. here index = 2 decides larger element.

In 1st test case: the substring "10" interchanged with "1100" only and not "11" or "110" or "11000" because:
    => "10" is a special string.
    => "1100" is a special string.
    => "11" is not a special string.
    => "110" is not a special string.
    => "11000" is not a special string.

New Test case: "1011001100"
=> Swap 1 -> parts: ["10", "1100", "1100"] -> Swap "10" with first "1100" -> "1100101100"
=> swap 2 -> parts: ["1100", "10", "1100"] -> Swap "10" and "1100" again  -> "1100110010" [OUTPUT]

# Remember we use "1"+recurse()+"0" because type of strings not allowed are 000111 [1st condition] and 110001 [2nd condition]

## ALGORITHM:--
Step 1: Base case
    => If the string is empty or just "10", return it directly. You can't break it further, it's already smallest unit.
Step 2: Break the string into parts
    => Go through the string one character at a time.
    => Keep a counter:
        -> Add 1 when you see '1'
        -> Subtract 1 when you see '0'
    => When the counter becomes 0, it means special substring.
        -> Take that substring
        -> Remove the first '1' and last '0'
        -> Do the same process again (recursion) on the inner part
        -> Then add "1" + inner_result + "0" to a list
Step 3: Sort the parts
    => After collecting all parts, sort them in descending order.
Step 4: Join the sorted parts
    => Put all the sorted strings together

*/