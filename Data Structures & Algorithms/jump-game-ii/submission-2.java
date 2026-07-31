class Solution {
    public int jump(int[] nums) {

        
        int dp[] = new int[nums.length];

        dp[nums.length -1] = 0;

        for(int i = nums.length -2 ;i>=0;i--){
            
            int j = nums[i];
            int min_value = 1000;

            for(int k = 1;k <= j;k++){
                if(i + k >= nums.length){
                    break;
                }

                min_value = Math.min(dp[i+k],min_value);
            }

            dp[i] = min_value+1;
        }

        return dp[0];
    }
}
