class Solution {

    public void recurse(List<String> ans , StringBuilder curr , int open,int close){

        if(open == 0 && close == 0){
            ans.add(new String(curr.toString()));
            return ;
        }

        if (open > 0) {
            curr.append('(');
            recurse(ans, curr, open - 1, close);
            curr.deleteCharAt(curr.length() - 1);
        }
        
        if(open < close){
            curr.append(')');
            recurse(ans,curr,open,close-1);
            curr.deleteCharAt(curr.length() -1);
        }

        return ;
    }
    public List<String> generateParenthesis(int n) {
        
        List<String> ans = new ArrayList<>();
        StringBuilder temp = new StringBuilder();

        recurse(ans,temp,n,n);
        
        return ans;
    }
}
