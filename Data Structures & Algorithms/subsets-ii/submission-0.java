class Solution {
    public void rec(int[] nums,Set<List<Integer>> ans,List<Integer> temp,int current){
        if(current == nums.length){
            ans.add(temp);
            return ;
        }

        temp.add(nums[current]);
        ans.add(new ArrayList<>(temp));
        rec(nums,ans,temp,current+1);
        temp.remove(temp.size()-1);
        rec(nums,ans,temp,current+1);

    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        int n = nums.length;
        Set<List<Integer>> ans = new HashSet<>();
        List<Integer> temp = new ArrayList<>();
        int current = 0;
        Arrays.sort(nums);

        rec(nums,ans,temp,current);

        List<List<Integer>> res = new ArrayList<>(ans);
        return res;
    }
}
