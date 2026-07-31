class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int left = 1;
        int right = 0;

        for (int num : piles) {
            right = Math.max(right, num);
        }

        int ans = -1;
        while(left <= right){

            int hours  = 0;
            int mid = (left + right)/2;

            for(int i = 0;i<piles.length;i++){
                hours += (piles[i]/mid);
                if(piles[i] % mid != 0){
                    hours ++;
                }
            }

            if(hours > h){
                left = mid + 1;
            }
            else{
                ans = mid;
                right = mid - 1;
            }
        }

        return ans;
    }
}
