class Solution {
public:
    int maxProfit(vector<int>& prices) {
        

        int minPri = prices[0];
        int maxProfit = 0;
        for(int i = 1; i < prices.size(); i++) {
            if(prices[i] < minPri) {
                minPri = prices[i];
            } else if(prices[i] - minPri > maxProfit) {
                maxProfit = prices[i] - minPri;
            }
        }
        return maxProfit;

        // int mini = INT_MAX;
        // int profit = 0;
        // for(int i=0 ; i< prices.size() ; i++)
        // {
        //     mini = min(mini ,prices[i]);
        //     if(mini < prices[i]){
        //         profit = max(profit , prices[i] - mini);
        //     }
        // }
        // return profit;

        // int ans = 0;
        // int n = prices.size();
        // int b = 0;
        // for(int i = 1; i < n; i++) {
        //     if(prices[i] < prices[b]) {
        //         b = i;
        //     }
        //     else {
        //         ans = max(ans, prices[i] - prices[b]);
        //     }
        // }
        // return ans;
    }
};
