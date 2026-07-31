class Solution {
    public String minWindow(String s, String t) {
        
        HashMap<Character, Integer> freq = new HashMap<>();
        HashMap<Character, Integer> windowfreq = new HashMap<>();

        for(int i = 0;i<t.length();i++){
            freq.put(t.charAt(i),freq.getOrDefault(t.charAt(i), 0)+1);
        }


        int left = 0;
        int need = freq.size();
        int have = 0;

        int minlen = Integer.MAX_VALUE;
        int start = 0;
        
        for(int right = 0;right < s.length(); right++){

            windowfreq.put(s.charAt(right),windowfreq.getOrDefault(s.charAt(right),0)+1);

            char ch = s.charAt(right);

            if(freq.containsKey(ch) && windowfreq.get(ch).intValue() == freq.get(ch).intValue()){
                have ++;
            }

            while(have == need){
                if (right - left + 1 < minlen) {
                    minlen = right - left + 1;
                    start = left;
                }

                char leftChar= s.charAt(left);
                windowfreq.put(leftChar,windowfreq.get(leftChar)- 1);

                if (freq.containsKey(leftChar) && windowfreq.get(leftChar) < freq.get(leftChar)){
                    have --;
                }
                left++;
            }
        }
        if (minlen == Integer.MAX_VALUE) {
            return "";
        }
        return s.substring(start, start + minlen);
    }
}
