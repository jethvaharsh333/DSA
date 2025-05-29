// time complexity : O(n), space complexity : O(1)
class Solution1 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if(prices==null || len<=1){
            return 0;
        }
        int buy=prices[0], sell=prices[0];
        int maxProfit = 0;
        
        for(int i=1 ; i<len ; i++){
            if(buy > prices[i]){
                buy = prices[i];
                sell = prices[i];
            }else if(sell < prices[i]){
                sell = prices[i];
            }else{
                continue;
            }
            int currProfit = sell - buy;
            if(currProfit > maxProfit) maxProfit = currProfit;
        }

        return maxProfit;
    }
}
