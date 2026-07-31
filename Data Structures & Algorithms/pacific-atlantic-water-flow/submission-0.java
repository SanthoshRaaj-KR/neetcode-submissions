class Solution {
    public void dfs(int[][] heights,int[][] visited,int i,int j){
        
        int n = heights.length;
        int m = heights[0].length;

        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

        if(i < 0 || i >= n || j < 0 || j >= m){
            return ;
        }
        if(visited[i][j] == 1){
            return ;
        }

        visited[i][j] = 1;

        for (int[] d : dir){

            int ni = i + d[0];
            int nj = j + d[1];

            if(ni < 0 || ni >= n || nj < 0 || nj >= m){
                continue;
            }

            if(visited[ni][nj] == 1){
                continue;
            }

            if(heights[ni][nj] >= heights[i][j]){
                dfs(heights, visited, ni, nj);
            }
        }

    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        
        int n = heights.length;
        int m = heights[0].length;

        int pacific[][] = new int[n][m];
        int atlantic[][] = new int[n][m];

        for(int i = 0; i < n; i++){
            dfs(heights, pacific, i, 0);
            dfs(heights, atlantic, i, m - 1);
        }

        for(int j = 0; j < m; j++){
            dfs(heights, pacific, 0, j);
            dfs(heights, atlantic, n - 1, j);
        }

        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 0;i<n;i++){
            for(int j =0;j<m;j++){
                if(pacific[i][j] == 1 && atlantic[i][j] == 1){
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);

                    ans.add(temp);
                }
            }
        }

        return ans;
    }
}
