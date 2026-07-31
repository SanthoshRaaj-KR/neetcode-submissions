class Solution {
    public void rec(int[] nums,boolean[] used,List<List<Integer>> res,List<Integer> temp){
        
        if(temp.size() == nums.length){
            res.add(new ArrayList<>(temp));
            return ;
        }

        for(int i = 0;i<nums.length;i++){
            if(used[i] == false){
                temp.add(nums[i]);
                used[i] = true;
                rec(nums,used,res,temp);
                temp.remove(temp.size()-1);
                used[i] = false;
            }
            else{
                continue;
            }
        }

    }
    public List<List<Integer>> permute(int[] nums) {
        
        int n = nums.length;

        boolean used[] = new boolean[n];

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        rec(nums,used,ans,temp);
        return ans ;
    }
}
