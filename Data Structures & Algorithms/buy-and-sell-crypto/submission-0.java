class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int buy = 0;
        int sell = 0;

        for(int i = 0;i<prices.length;i++){

            if(prices[i] < prices[buy]){
                buy = i;
                sell = i;
            }

            if(prices[sell] < prices[i]){
                sell = i;
            }

            int profit = prices[sell] - prices[buy];
            maxProfit = Math.max(profit, maxProfit);
        }

        return maxProfit;
    }
}
