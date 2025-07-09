package RECURSION_AND_BACKTRACKING.RECURSION.AAG_Minimum_Non_Zero_Product_of_the_Array_Elements;

import java.util.*;

/**
 * Question link:
 * Date: 02-07-2025
 * Time complexity:
 * Space complexity:
 */

public class Solution {
    public int mod = 1_000_000_007; // 10^9 + 7

    public int minNonZeroProduct(int p) {
        if (p == 1) return 1;

        long mx = (long)(Math.pow(2, p)) - 1;
        long sm = mx - 1;
        long n = sm/2;
        long sum = rec(sm, n); // Fast power function

        return (int)(sum * (mx % mod) % mod);
    }

    public long rec(long val, long n) {
        if (n == 0) return 1;
        if (n == 1) return (val % mod);

        long newVal = ((val % mod) * (val % mod)) % mod;

        if(n%2 != 0){
            return ((rec(newVal, n/2) % mod) * (val % mod)) % mod;
        }

        return rec(newVal, n/2) % mod;
    }
}

/*

This approach converts an O(n) exponentiation into O(log n) time using recursion.

3^5 = 3 * (3^2)^2
    = 3 * 9^2
    = 3 * 81


| RECURSIVE CALLS         | BACKTRACKED
| ----------------------------------------------
| rec(3, 5)               | => 243
| newVal = 3*3            |
|     rec(9, 2) * 3       | => 81*3 = 243
|     newVal = 9*9        |
|         rec(81, 1)      | => 81

= 243
[Instead of 5 recursion calls it's settled on 3]

Java's int overflows at around ±2 * 10⁹. Hence used: 1_000_000_007

| RECURSIVE CALLS | ACTION                    | RESULT / COMMENT         |
| --------------- | ------------------------- | ------------------------ |
| rec(5, 11)      | 11 is odd                 | return rec(25, 5) \* 5   |
| rec(25, 5)      | 5 is odd                  | return rec(625, 2) \* 25 |
| rec(625, 2)     | even                      | return rec(390625, 1)    |
| rec(390625, 1)  | base case                 | return 390625            |
|                 | unwind stack              |                          |
| rec(625, 2)     | = 390625                  |                          |
| rec(25, 5)      | = 390625 \* 25 = 9765625  |                          |
| rec(5, 11)      | = 9765625 \* 5 = 48828125 |                          |

*/