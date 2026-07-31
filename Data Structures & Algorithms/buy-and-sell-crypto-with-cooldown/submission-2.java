class Solution {

    Integer dp[][] ;

    public int recurse(int prices[] ,int day,int canBuy){

        if(day >= prices.length){
            return 0;
        }

        if(dp[day][canBuy]!=null){
            return dp[day][canBuy];
        }

        if(canBuy == 1){

            int buy = recurse(prices,day+1,0)-prices[day] ;
            int skip = recurse(prices,day+1,1);

            dp[day][canBuy] = Math.max(buy,skip);
        }
        else{
            int sell = prices[day] + recurse(prices,day+2,1);
            int skip = recurse(prices,day+1,0);

            dp[day][canBuy] = Math.max(sell,skip);
        }

        return dp[day][canBuy];
    }

    public int maxProfit(int[] prices) {

        dp = new Integer[prices.length][2];
        return recurse(prices,0,1);
        
        
    }
}
