class Solution {
    public int singleNumber(int[] nums) {
        
        int trump = 0;
        for(int i  = 0;i<nums.length;i++){
            trump ^= nums[i];
        }

        return trump;
    }
}
