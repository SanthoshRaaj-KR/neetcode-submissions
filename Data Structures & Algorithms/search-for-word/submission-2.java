class Solution {
    public boolean recurseDFS(char[][] board, int i,int j ,String word,int curr,boolean[][] visited){

        int n = board.length;
        int m = board[0].length;

        if(i < 0 || i >=n || j < 0 ||j >= m){
            return false;
        }

        if(board[i][j] != word.charAt(curr)){
            visited[i][j] = false;
            return false;
        }

        if (visited[i][j]) {
            return false;
        }

        if(curr == word.length()-1){
            return true;
        }

        visited[i][j] = true;

        boolean top = recurseDFS(board,i-1,j,word,curr+1,visited);
        boolean bottom = recurseDFS(board,i+1,j,word,curr+1,visited);
        boolean right = recurseDFS(board,i,j+1,word,curr+1,visited);
        boolean left = recurseDFS(board,i,j-1,word,curr+1,visited);

        if(top || bottom || right || left){
            return true;
        }

        visited[i][j] = false;
        return false;
    }

    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        boolean visited[][] = new boolean[n][m];

        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(board[i][j] == word.charAt(0)){
                    boolean ans = recurseDFS(board, i , j,word,0,visited);
                    if(ans){
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
