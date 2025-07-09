package RECURSION_AND_BACKTRACKING.RECURSION.AAS_Integer_To_English_Words;

import java.util.*;

/**
 * Question link: https://leetcode.com/problems/integer-to-english-words/description/
 * Date: 09-07-2025
 * Time complexity:
 * Space complexity:
 */

public class Solution {
    private final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        if (num == 0) return "Zero";

        int i = 0;
        String words = "";

        while(num > 0){
            if(num%1000 != 0){
                words = helper(num%1000) +THOUSANDS[i] + " " + words;
            }

            num /= 1000;
            i++;
        }

        return words.trim();
    }

    private String helper(int num){
        if(num == 0)
            return "";
        else if(num < 20)
            return LESS_THAN_20[num] + " ";
        else if(num < 100)
            return TENS[num/10] + " " + helper(num%10);
        else
            return LESS_THAN_20[num/100] + " Hundred " + helper(num%100);
    }
}

/*

Thousand    => 1,000
Million     => 1,000,000
Crore       => 10,000,000
Billion     => 1,000,000,000
Trillion    => 1,000,000,000,000

e.g. : 12,34,567

i = 0, num % 1000 = 567
    → helper(567)
        → LESS_THAN_20[5] + " Hundred " + helper(67)
            → "Five Hundred " + TENS[6] + " " + helper(7)
                → "Sixty " + LESS_THAN_20[7] + " " → "Seven "
    → Final = "Five Hundred Sixty Seven "
    Append: "Five Hundred Sixty Seven " + THOUSANDS[0] + " " = "Five Hundred Sixty Seven "

i = 1, num = 1234, num % 1000 = 234
    → helper(234)
        → LESS_THAN_20[2] + " Hundred " + helper(34)
            → "Two Hundred " + TENS[3] + " " + helper(4)
                → "Thirty " + LESS_THAN_20[4] + " " → "Four "
    → Final = "Two Hundred Thirty Four"
    Append: "Two Hundred Thirty Four " + THOUSANDS[1] + " " = "Two Hundred Thirty Four Thousand "

i = 2, num = 1, num % 1000 = 1
    → helper(1) → LESS_THAN_20[1] + " " → "One "
    Append: "One " + THOUSANDS[2] + " " = "One Million"
*/