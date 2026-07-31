class Solution {

    public String encode(List<String> strs) {
        String encode = "";
        for(String word : strs){
            int n = word.length();

            encode+=n+"#"+word;
        }

        return encode;
    }

    public List<String> decode(String str) {
        
        List<String> ans = new ArrayList<>();
        int i = 0;
        int j = 1;

        while(i < str.length()) {

            int len = 0;

            while(str.charAt(i) != '#') {
                len = len * 10 + (str.charAt(i) - '0');
                i++;
            }

            i++;

            String word = str.substring(i, i + len);
            ans.add(word);

            i += len;
        }

        return ans;
    }
}
