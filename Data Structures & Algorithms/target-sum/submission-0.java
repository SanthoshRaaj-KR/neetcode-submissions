class Solution {

    public int recurse(int current,int sum,int target,int[] nums,int dp[][],int offset){
        
        if(current ==  nums.length){
            if( target ==  sum){
                return 1;
            }
            else{
                return 0;
            }
        }  

        if (dp[current][sum + offset] != -1) {
            return dp[current][sum + offset];
        }

        int add = recurse(current+1,sum+nums[current],target,nums,dp,offset);
        int subtract = recurse(current+1,sum-nums[current],target,nums,dp,offset);

        dp[current][sum + offset] = add + subtract;

        return add + subtract;

    }

    public int findTargetSumWays(int[] nums, int target) {
        
        
        int total = 0;

        for(int i : nums){
            total += i;
        }

        int offset = total;
        int[][] dp = new int[nums.length][2 * total + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        
        int ans = recurse(0,0,target,nums,dp,offset); 
        return ans;
    }
}
