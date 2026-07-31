class Solution {

    public void helper(int[] nums,int index,int sum,int target,List<Integer> current,List<List<Integer>> ans){
        
        if(sum == target){
            ans.add(new ArrayList<>(current));
            return ;
        }

        if(index == nums.length || sum > target){
            return ;
        }

        current.add(nums[index]);
        int org = index;
        helper(nums,index+1,sum+nums[org],target,current,ans);
        current.remove(current.size()-1);
        
        while(index != nums.length-1 && nums[index] == nums[index+1]){
            index++;
        }
        
        
        helper(nums,index+1,sum,target,current,ans);

    }
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        Arrays.sort(nums);

        helper(nums,0,0,target,current,ans);

        return ans;
    }
}
