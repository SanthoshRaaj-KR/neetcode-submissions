class Solution {
    public int recurse(String s , int i ,int[] dp){
        
        int ways = 0;

        if(i == s.length()){
            return 1;
        }

        if(s.charAt(i) == '0'){
            return 0;
        }

        if(s.charAt(i)!= '0'){
            ways+=recurse(s,i+1,dp);
        }

        if(dp[i]!= -1){
            return dp[i];
        }

        if(i+1 < s.length()){
                    if(Integer.parseInt(s.substring(i,i+2)) >= 10 && Integer.parseInt(s.substring(i,i+2)) <= 26 ){
                
                ways+=recurse(s,i+2,dp);
            }
        }
        dp[i] = ways;
        return ways;
    }
    public int numDecodings(String s) {
        
        int dp[] = new int[s.length()];

        Arrays.fill(dp,-1);
        return recurse(s,0,dp);
    }
}
