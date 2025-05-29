// It won't work for n>=13

class Solution1 {
    public int trailingZeroes(int n) {
        int ans = factorial(n);
        int count = 0;

        while(ans%10 == 0){
            count++;
            ans /= (int)10;
        }

        return count;
    }

    private int factorial(int n){
        if(n==0) return 1;
        return n*factorial(n-1);
    }
}
