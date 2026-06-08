package DP.One_Dimensional.AAA_Fibonacci_Number;

import java.util.Arrays;

public class Memoize {
    public int fib(int n) {
        int[] memo = Arrays.stream(new int[n+1]).map(e -> -1).toArray();
        return fib(n, memo);
    }

    private int fib(int n, int[] memo){
        if(n <= 2)
            return n == 0 ? 0 : 1;

        if(memo[n] != -1)
            return memo[n];

        memo[n] = fib(n-1,memo) + fib(n-2,memo);
        return memo[n];
    }
}
