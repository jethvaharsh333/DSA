// Time complexity: O(2^n), Space complexity: O(n)
class Solution1 {
    public int numTrees(int n) {
        if(n==0 || n==1){
            return 1;
        }

        int sum = 0;
        for(int i=1 ; i<=n ; i++){
            sum += numTrees(i-1)*numTrees(n-i);
        }

        return sum;
    }
}
