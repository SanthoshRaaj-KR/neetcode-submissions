class Solution {
    public boolean rotOrange(int[][] grid, int newRow, int newCol,
                          int n, int m, Queue<int[]> q) {

        if (newRow < 0 || newRow >= n || newCol < 0 || newCol >= m) {
            return false;
        }

        if (grid[newRow][newCol] != 1) {
            return false;
        }

        grid[newRow][newCol] = 2;
        q.offer(new int[]{newRow, newCol});

        return true;
    }

    public int orangesRotting(int[][] grid) {
    
        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                }
                    if (grid[i][j] == 1) {
                        fresh++;
                    }
            }
        }

        int time = 0;

        if (fresh == 0){
            return 0;
        }
            

        if (q.isEmpty()){
            return -1;
        }
           

        while(!q.isEmpty()){

            int size = q.size();
            
            for(int i = 0;i<size;i++){
                int[] currentPos = q.poll();

                int currentRow = currentPos[0];
                int currentCol = currentPos[1];

                if(rotOrange(grid,currentRow+1,currentCol,n,m,q))
                    fresh--;

                if(rotOrange(grid,currentRow,currentCol+1,n,m,q))
                    fresh--;

                if(rotOrange(grid,currentRow-1,currentCol,n,m,q))
                    fresh--;

                if(rotOrange(grid,currentRow,currentCol-1,n,m,q))
                    fresh--;

            }

            if (!q.isEmpty()) {
                time++;
            }
            

        }

        if (fresh == 0){
            return time;
        }
        else{
            return -1;
        }
    }
}
