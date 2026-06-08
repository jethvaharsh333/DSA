package DP.One_Dimensional.AAA_Fibonacci_Number;

public class SpaceOpimized {
    public int fib(int n) {
        int prev2=0, prev=1;

        int curr = 0;
        for(int i=2 ; i<=n ; i++){
            curr = prev2 + prev;
            prev2 = prev;
            prev = curr;
        }

        return prev;
    }
}
