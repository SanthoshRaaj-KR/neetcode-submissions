class Solution {

    public void addRoom(
        int[][] grid,int currRow,int currCol,int newRow,int newCol,
        int n,int m,Queue<int[]> q,boolean[][] visited)
    {

        if (newRow < 0 || newRow >= n || newCol < 0 || newCol >= m) {
            return;
        }

        // Wall
        if (grid[newRow][newCol] == -1) {
            return;
        }

        if (visited[newRow][newCol]) {
            return;
        }

        grid[newRow][newCol] = grid[currRow][currCol] + 1;

        visited[newRow][newCol] = true;
        q.add(new int[]{newRow,newCol});

    }
    public void islandsAndTreasure(int[][] grid) {

        int n =  grid.length;
        int m = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        boolean visited[][] = new boolean[n][m];

        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j] == 0){
                    q.add(new int[]{i,j});
                    visited[i][j] = true;
                }
            }
        }
        
        
        while(!q.isEmpty()){
            
            int[] pos = q.poll();
            int i = pos[0];
            int j = pos[1];


            addRoom(grid, i, j, i + 1, j, n, m, q, visited);
            addRoom(grid, i, j, i - 1, j, n, m, q, visited);
            addRoom(grid, i, j, i, j + 1, n, m, q, visited);
            addRoom(grid, i, j, i, j - 1, n, m, q, visited);


        }
    }
}
