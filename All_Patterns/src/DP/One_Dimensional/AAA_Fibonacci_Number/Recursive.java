package DP.One_Dimensional.AAA_Fibonacci_Number;

public class Recursive {
    public int fib(int n) {
        if(n<2) return n;
        return fib(n-1)+fib(n-2);
    }
}
