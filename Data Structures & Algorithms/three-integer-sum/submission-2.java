class Solution {

    public void twosum(int[] nums, int i, int target, Set<List<Integer>> ans) {

        int left = i + 1;
        int right = nums.length - 1;

        while (left < right) {

            int sum = nums[left] + nums[right];

            if (sum == target) {

                ans.add(Arrays.asList(nums[i], nums[left], nums[right]));

                left++;
                right--;

            } else if (sum > target) {

                right--;

            } else {

                left++;

            }
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);

        Set<List<Integer>> ans = new HashSet<>();

        for (int i = 0; i < nums.length - 2; i++) {

            int target = -nums[i];

            twosum(nums, i, target, ans);
        }

        return new ArrayList<>(ans);
    }
}