class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        int ans[] = new int[nums.length-k+1];
        int idx = 0;

        for(int i = 0;i<k;i++){
            pq.offer(new int[]{nums[i], i});
        }

        int temp[] = pq.peek();
        ans[idx++] = temp[0];

        int left = 1;
        int right = k;

        while(right < nums.length){

            pq.offer(new int[]{nums[right], right});

            while (!pq.isEmpty() && pq.peek()[1] < left) {
                pq.poll();
            }

            ans[idx++] = pq.peek()[0];
            right ++;
            left++;
        }
        return ans;
    }
}
