// Time complexity: O(n), Space complexity: O(1)

class Solution4 {
    public int climbStairs(int n) {
        if(n == 0) return 1;
        if(n == 1) return 1;

        int curr=0;
        int prev=1, prevOfPrev=1;
        for(int i=2 ; i<=n ; i++){
            curr = prev+prevOfPrev;
            prevOfPrev = prev;
            prev = curr ;
        }

        return curr;
    }
}
