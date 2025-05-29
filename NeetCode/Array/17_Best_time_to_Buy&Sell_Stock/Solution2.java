// Time complexity: O(n), Space complexity: O(1), OPTIMAL SOLUTION
class Solution2 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if(prices==null || len<=1){
            return 0;
        }
        
        var left = 0;
        var right = 1;
        var maxProfit = 0;
        while(right < prices.length) {
            if (prices[left] < prices[right]) {
                var profit = prices[right] - prices[left];
                maxProfit = Math.max(maxProfit, profit);
            } else {
                left = right;
            }
            right++;
        }
        return maxProfit;
    }
}
