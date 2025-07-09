package RECURSION_AND_BACKTRACKING.RECURSION.AAF_Count_Good_Numnbers;

/**
 * Question link: https://leetcode.com/problems/count-good-numbers/
 * Date: 09-07-2025
 * Time complexity:
 * Space complexity:
 */

public class Solution {
    // Define MOD as a class variable for easier reference and readability
    public long MOD = 1_000_000_007;

    public int countGoodNumbers(long n) {

        // Calculate the number of even and odd positions in the digit string
        long odd = n/2;
        long even = (n+1)/2;

        // Calculate the total number of good digit strings
        // multiplying 5 by even because there could only be 5 even numbers between 0-9
        // multiplying 4 by odd because there could only be 4 prime numbers between 0-9
        return (int)(pow(5,even) * pow(4,odd) % MOD);
    }

    public long pow(long x, long n){
        // Base case for the recursion
        if(n == 0)
            return 1;

        // Recursively calculate x^(n/2)
        long temp = pow(x, n/2);

        // If n is even, return (x^(n/2))^2
        if(n%2 == 0){
            return (temp * temp) % MOD;
        }

        // If n is odd, return (x^(n/2))^2 * x
        else{
            return (x * temp * temp) % MOD;
        }
    }
}

/*

Index:     0   1   2   3
Position:  E   O   E   O
Digit:    even prime even prime

5^4 => pow(5, 4)
    => temp = pow(5, 2)
        => temp = pow(5, 1)
            => temp = pow(5, 0)
                => return 1
            => return 5 * 1 * 1 = 5
        => return 5 * 5 = 25
    => return 25 * 25 = 625

pow(5, 7)
├─ pow(5, 3)
│  ├─ pow(5, 1)
│  │  ├─ pow(5, 0) = 1
│  │  └─ result = (1 * 1 * 5) % MOD = 5
│  └─ result = (5 * 5 * 5) % MOD = 125
└─ result = (125 * 125 * 5) % MOD = 78125

pow(4, 7)
├─ pow(4, 3)
│  ├─ pow(4, 1)
│  │  ├─ pow(4, 0) = 1
│  │  └─ result = (1 * 1 * 4) % MOD = 4
│  └─ result = (4 * 4 * 4) % MOD = 64
└─ result = (64 * 64 * 4) % MOD = 16384

*/