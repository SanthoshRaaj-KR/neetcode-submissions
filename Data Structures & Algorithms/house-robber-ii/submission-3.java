class Solution {
    public int helper(int start, int end, int[] nums){

    if(start == end){
        return nums[start];
    }

    int[] dp = new int[nums.length];

    dp[start] = nums[start];
    dp[start + 1] = Math.max(nums[start], nums[start + 1]);

    for(int i = start + 2; i <= end; i++){
        dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
    }

    return dp[end];
}

public int rob(int[] nums){

    if(nums.length == 1){
        return nums[0];
    }

    return Math.max(
        helper(0, nums.length - 2, nums),
        helper(1, nums.length - 1, nums)
    );
    }
}
