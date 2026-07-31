class Solution {

    public boolean timepassfucker(int i ,int j ,String s1,String s2,String s3,Boolean[][] dp){
        
        if(i == s1.length() && j == s2.length()){
            return true;
        }

        if(dp[i][j]!= null){
            return dp[i][j];
        }

        int k = i + j;

        Boolean ans = false;

        if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
            ans = timepassfucker(i + 1, j, s1, s2, s3, dp);
        }

        if (j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
            ans = timepassfucker(i, j + 1, s1, s2, s3, dp);
        }

        dp[i][j] = ans;
        return dp[i][j];

    }   

    public boolean isInterleave(String s1, String s2, String s3) {
        
        if(s1.length()+s2.length() != s3.length()){
            return false;
        }

        Boolean[][] dp = new Boolean[s1.length() + 1][s2.length() + 1];

        return timepassfucker(0,0,s1,s2,s3,dp);
    }
}
