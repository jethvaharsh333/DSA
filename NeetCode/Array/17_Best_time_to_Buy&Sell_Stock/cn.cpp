int bestTimeToBuyAndSellStock(vector<int>&prices) {
    int n = prices.size();
    int min = prices[0];
    int max = prices[0];
    int maxProfit = 0;

    for(int i=0 ; i<n ; i++){
        if(min > prices[i]){
            min = prices[i];
            max = 0;
            if(max-min > maxProfit) maxProfit = (max-min);
        }
        if(max < prices[i]){
            max = prices[i];
            if(max-min > maxProfit) maxProfit = (max-min);
        }
    }

    return maxProfit;
}
