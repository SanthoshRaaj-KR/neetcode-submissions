class Solution {
    public boolean canJump(int[] nums) {
        
        int farthest = 0;

        for(int i = 0;i<nums.length;i++){

            if(i > farthest){
                return false;
            }

            if(farthest >= nums.length -1){
                return true;
            }

            farthest = Math.max(farthest,i+nums[i]);

        }

        return true;
    }
}
