class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) {
            return false;
        }

        int[] freq = new int[26];
        int[] windowfreq = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            freq[s1.charAt(i) - 'a']++;
            windowfreq[s2.charAt(i) - 'a']++;
        }

        int left = 0;
        int right = s1.length();

        while (right < s2.length()) {
            for (int i = 0; i < 26; i++) {
                if (freq[i] != windowfreq[i]) {
                    break;
                }

                if (i == 25) {
                    return true;
                }
            }

            windowfreq[s2.charAt(left) - 'a']--;
            left++;

            windowfreq[s2.charAt(right) - 'a']++;
            right++;
        }

        for (int i = 0; i < 26; i++) {
            if (freq[i] != windowfreq[i]) {
                break;
            }

            if (i == 25) {
                return true;
            }
        }

        return false;
    }
}