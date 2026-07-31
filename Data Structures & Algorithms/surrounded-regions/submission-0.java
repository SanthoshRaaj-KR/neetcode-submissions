class Solution {

    public void dfs(char[][] board,int[][] visited,int i,int j){

        int n = board.length;
        int m = board[0].length;

        if(i >= n || i<0|| j>=m || j<0){
            return ;
        }

        if(board[i][j]!='O'){
            return ;
        }
        
        if(visited[i][j] == 1){
            return ;
        }

        visited[i][j] = 1;

        dfs(board,visited,i+1,j);
        dfs(board,visited,i-1,j);
        dfs(board,visited,i,j+1);
        dfs(board,visited,i,j-1);
    }

    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        int visited[][] = new int[n][m];

        for(int i = 0;i<m;i++){
            if(board[0][i] == 'O'){
                dfs(board,visited,0,i);
            }
            if(board[n-1][i] == 'O'){
                dfs(board,visited,n-1,i);
            }
        }
        for(int i = 0;i<n;i++){
            if(board[i][0] == 'O'){
                dfs(board,visited,i,0);
            }
            if(board[i][m-1] == 'O'){
                dfs(board,visited,i,m-1);
            }
        }

        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                if(visited[i][j]!=1){
                    board[i][j] = 'X';
                }
            }
        }
    }
}
