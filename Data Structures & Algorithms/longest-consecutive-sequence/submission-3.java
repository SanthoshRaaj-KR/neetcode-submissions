class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> h = new HashSet<Integer>();

        for(int i=0;i<nums.length;i++){
            h.add(nums[i]);
        }

        int longest = 0;

        if(h.size() == 1){
            return 1;
        }
        for(int num:h){

            if(!h.contains(num-1)){
                int current = num;
                int count = 1;

                while(h.contains(current+1)){
                    current ++;
                    count++;  
                }
                longest = Math.max(longest , count);
            }
        }

        return longest;
    }
}
