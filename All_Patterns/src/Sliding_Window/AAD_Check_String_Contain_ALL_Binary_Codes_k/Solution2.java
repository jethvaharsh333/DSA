package Sliding_Window.AAD_Check_String_Contain_ALL_Binary_Codes_k;

import java.util.Scanner;

public class Solution2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter string: ");
        String s1 = sc.nextLine();

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        Boolean ans = hasAllCodes(s1, k);
        System.out.println(ans);
    }

    public static boolean hasAllCodes(String s, int k) {
        int need = 1 << k;
        boolean[] seen = new boolean[need];
        int hash = 0;
        int allOnes = need-1;
        int count = 0;

        if (s.length() < k) return false;

        for(int i=0 ; i<s.length() ; i++){
            hash = ((hash << 1) & allOnes) | (s.charAt(i) - '0');

            if(i >= k-1){
                if(!seen[hash]){
                    seen[hash] = true;
                    count++;
                    if(count == need) return true;
                }
            }
        }

        return false;
    }

/*
    Code                             | Why it exists
    -------------------------------- | ------------------------------------------------------
    `int hash = 0`                   | Store the current rolling binary substring as a number (Converting substrings manually is slow)
    `int allOnes = need - 1`         | Keep only the last k bits using a mask
    `hash = ((hash << 1) & allOnes)  | (s.charAt(i) - '0')\`
    `count++`                        | Count how many unique k-length substrings we've found

*/

/*
    EXAMPLE:
    s = "11010" and k = 3

    We want to track all substrings of length 3:
    "110", "101", "010"

    build hash step by step:

    Iteration 1: i = 0 → '1'
    hash = 0
    hash << 1 = 0, & allOnes = 0, | 1 = 1

    Iteration 2: i = 1 → '1'
    hash = 1
    1 << 1 = 10, & 111 = 10, | 1 = 11 → hash = 3

    Iteration 3: i = 2 → '0'
    3 << 1 = 110, & 111 = 110, | 0 = 110 → hash = 6
    We now have 3 bits ⇒ check if seen before

    Iteration 4: i = 3 → '1'
    6 << 1 = 1100, & 111 = 100, | 1 = 101 → hash = 5
    New substring

    -------------------------------------------------------------

    | i | char | hash (binary) | hash (decimal) | Seen Before? | count |
    | - | ---- | ------------- | -------------- | ------------ | ----- |
    | 0 | '0'  | 0             | —              | —            | —     |
    | 1 | '0'  | 00            | 0              | No           | 1     |
    | 2 | '1'  | 01            | 1              | No           | 2     |
    | 3 | '1'  | 11            | 3              | No           | 3     |
    | 4 | '0'  | 10            | 2              | No           | 4     |


*/
}
