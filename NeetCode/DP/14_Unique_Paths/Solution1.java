// Time complexity: O(2^n), Space complexity: O(n) [Time limit exceeded]

class Solution1 {
    public int uniquePaths(int m, int n) {
        return recurse(m-1, n-1);
    }

    private int recurse(int m, int n){
        if(m==0 && n==0){
            return 1;
        }

        if(m<0 || n<0){
            return 0;
        }

        int ways = recurse(m-1, n) + recurse(m, n-1);

        return ways;
    }
}
