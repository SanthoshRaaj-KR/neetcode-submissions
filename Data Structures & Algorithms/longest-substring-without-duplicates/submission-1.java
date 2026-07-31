class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = left +1;
        HashSet<Character> h = new HashSet<>();

        if(s.length() < 1){
            return 0;
        }
        if(s.length() == 1){
            return 1;
        }

        int maxCount = 0;
        h.add(s.charAt(0));

        while( right < s.length()){
            char ch = s.charAt(right);

            if(!h.contains(ch)){
                h.add(ch);
                right ++;
            }
            else{
                h.remove(s.charAt(left));
                left ++;
            }

            int count = right - left ;
            maxCount = Math.max(count,maxCount);
        }

        return maxCount;
    }
}
