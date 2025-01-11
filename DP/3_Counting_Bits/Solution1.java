// Time complexity: O(n*log(n)), Space complexity: O(n)

class Solution1 {
    public int[] countBits(int n) {
        int[] ans = new int[n+1];

        for(int i=0 ; i<=n ; i++){
            ans[i] = countOnesUsingAnd(i);
        } 

        return ans;
    }

    private static int countOnesUsingAnd(int num) {
        int count = 0;
        int bitChecker = 1;

        while(num >= bitChecker){
            if((num & bitChecker) != 0){
                count++;
            }
            bitChecker <<= 1;
        }

        return count;
    }
}
