class Solution {
    public int characterReplacement(String s, int k) {
        
        int freq[] = new int[26];
        int n = s.length();
        int left = 0;
        int maxFreq = 0;
        int maxCount = 0;

        for(int right = 0;right<n;right++){

            char ch = s.charAt(right);
            freq[ch-'A'] ++;
            maxFreq = Math.max(maxFreq , freq[ch-'A']);

            while((right -left + 1) - maxFreq > k){
                freq[s.charAt(left) -'A']--;
                left++;
            }

            maxCount = Math.max(maxCount, right - left + 1);
        }

        return maxCount;
    }
}
