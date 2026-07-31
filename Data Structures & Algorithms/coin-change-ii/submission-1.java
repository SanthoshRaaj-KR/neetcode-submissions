class Solution {
    public int recurse(int current,int dp[][] ,int[] coins,int amount){
        
        if(amount == 0){
            return 1;
        }

        if(current == coins.length){
            return 0;
        }
        
        if(amount < 0){
            return 0;
        }

        if(dp[current][amount] != -1){
            return dp[current][amount];
        }

        int skip = recurse(current+1,dp,coins,amount);
        int take = 0;
        take = recurse(current,dp,coins,amount - coins[current]);

        dp[current][amount] = take + skip;
        return take + skip;

    }

    public int change(int amount, int[] coins) {
        
        int dp[][] = new int[coins.length][amount+1];

        for(int i =0;i<coins.length;i++){
            Arrays.fill(dp[i],-1);
        }
        
        return recurse(0,dp,coins,amount);
    }
}
