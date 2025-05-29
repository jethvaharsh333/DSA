// Time complexity: O(n*log(max(n))), Space complexity: O(n)

class Solution2 {
    public int[] countBits(int n) {
        int[] ans = new int[n+1];

        for(int i=0 ; i<=n ; i++){
            ans[i] = countOnesUsingAnd(i);
        } 

        return ans;
    }

    private static int countOnesUsingAnd(int num) {
        int count = 0;

        while(num > 0){
            num = num & num-1;
            count++;
        }

        return count;
    }
}
