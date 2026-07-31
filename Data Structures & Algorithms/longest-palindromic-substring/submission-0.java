class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean dp[][] = new boolean[n][n];

        for(int i = 0;i<n;i++){
            Arrays.fill(dp[i],false);
        }

        int resInd = 0;
        int resLen = 0;

        for(int i = n-1;i>=0;i--){
            for(int j = i;j<n;j++){
                if(s.charAt(i) == s.charAt(j) && (j-i <= 2 || dp[i+1][j-1]== true)){
                    dp[i][j] = true;

                    int currlen = j - i+1;
                    if(currlen > resLen){
                        resLen = currlen;
                        resInd = i;
                    }
                    
                }
            }
        }


        return s.substring(resInd, resInd + resLen);
        
    }
}
