package DP.One_Dimensional.AAG_96_Unique_Binary_Search_Trees;

import java.util.Arrays;

public class Memoization {
    public int numTrees(int n) {
        int[] memo = new int[n+1];
        Arrays.fill(memo, -1);

        return recurse(n, memo);
    }

    public int recurse(int n, int[] memo) {
        if (n == 0 || n == 1) return 1;
        if (memo[n] != -1) return memo[n];

        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += recurse(i - 1, memo) * recurse(n - i, memo);
        }

        return memo[n] = sum;
    }
}
