package DP.One_Dimensional.AAE_279_Perfect_Squares;

public class Recursive {
    public int numSquares(int n) {
        if(n == 0) return 0;

        int min = Integer.MAX_VALUE;

        for(int j=1 ; j*j<=n ; j++){
            int remainder = n - j*j;
            min = Math.min(min, numSquares(remainder));
        }

        return 1 + min;
    }
}
