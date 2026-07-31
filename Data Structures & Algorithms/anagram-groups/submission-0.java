class Solution {

    public boolean isGrAnagram(String s1,String s2){
        
        if(s1.length()!=s2.length()){
            return false;
        }

        int count[] = new int[26];

        for(int i = 0;i<s1.length();i++){
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);
        
            int c1 = ch1-'a';
            int c2 = ch2-'a';

            count[c1]++;
            count[c2]--;
        }

        for(int i = 0;i<26;i++){
            if(count[i] != 0){
                return false;
            }
        }
        return true;
        
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();

        List<String> group1 = new ArrayList<>();
        group1.add(strs[0]);
        ans.add(group1);
        for(int i = 1;i<strs.length;i++){
            int flag = 0;
            for(int j = 0;j<ans.size();j++){
                String blob = ans.get(j).get(0);
                if(isGrAnagram(blob,strs[i])){
                    ans.get(j).add(strs[i]);
                    flag = 1;
                    break;
                }
            }
            if(flag == 0){
                List<String> group2 = new ArrayList<>();
                group2.add(strs[i]);  
                ans.add(group2); 
            }
        }

        return ans;
    }
}
