class Solution {
    public int recurse(String s , int i ){
        
        int ways = 0;

        if(i == s.length()){
            return 1;
        }

        if(s.charAt(i) == '0'){
            return 0;
        }

        if(s.charAt(i)!= '0'){
            ways+=recurse(s,i+1);
        }

        if(i+1 < s.length()){
                    if(Integer.parseInt(s.substring(i,i+2)) >= 10 && Integer.parseInt(s.substring(i,i+2)) <= 26 ){
                
                ways+=recurse(s,i+2);
            }
        }
        return ways;
    }
    public int numDecodings(String s) {
        
        return recurse(s,0);
    }
}
