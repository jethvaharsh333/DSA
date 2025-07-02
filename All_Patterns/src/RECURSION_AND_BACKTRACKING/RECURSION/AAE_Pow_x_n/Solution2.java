package RECURSION_AND_BACKTRACKING.RECURSION.AAE_Pow_x_n;

import java.util.Scanner;

/**
 * Question link: https://leetcode.com/problems/powx-n/
 * Date: 02-07-2025
 * Time complexity: O(log n) – because we halve the exponent each time
 * Space complexity: O(log n) – due to recursive calls stack
 */

/*
| Aspect                                | Your Version                             | Optimized Version                                 |
| ------------------------------------- | ---------------------------------------- | ------------------------------------------------- |
| ✅ **Handles n == 0**                  | Yes                                      | Yes                                               |
| ❌ **Handles `n = Integer.MIN_VALUE`** | ❌ Fails due to `-n` overflow             | ✅ Safe: uses `long N = n`                         |
| ❌ **Time Complexity**                 | O(n) → very slow for large `n`           | ✅ O(log n) → fast with exponentiation-by-squaring |
| ❌ **Stack Overflow Risk**             | High due to deep recursion               | ✅ Very low, fewer recursive calls                 |
| ❌ **Repeated Work**                   | Yes → computes x again and again         | ✅ No → reduces calls via squaring                 |
| ❌ **Memory Efficient**                | No → deep recursion stack                | ✅ Much fewer stack frames                         |
| ❌ **Numerical Stability**             | 1 / (x \* pow(x, n+1)) accumulates error | ✅ Inverts `x` once and reuses                     |

* */

public class Solution2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter base (x): ");
        double x = sc.nextDouble();

        System.out.print("Enter exponent (n): ");
        int n = sc.nextInt();

        double result = myPow(x, n);
        System.out.println("Result of x^n is: " + result);
    }

    public static double myPow(double x, int n) {
        // Base condition: If n is 0, x^0 is 1
        if (n == 0) {
            return 1;
        }

        // Convert n to a long integer to handle the edge case with Integer.MIN_VALUE
        long N = n;

        // If n is negative, take the reciprocal of x and make N positive
        if (N < 0) {
            N = -N;
            x = 1 / x;
        }

        // If N is even, recursively compute the square of x^(N/2)
        if (N % 2 == 0) {
            return myPow(x * x, (int) (N / 2));
        }

        // If N is odd, recursively compute x^(N-1) and multiply it by x
        else {
            return x * myPow(x, (int) (N - 1));
        }
    }
}