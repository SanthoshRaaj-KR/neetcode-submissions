class Solution {
    public boolean dfs(int current , List<List<Integer>> edges,boolean visited[]){

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{current , -1});
        visited[current] = true;

        while(!q.isEmpty()){

            int arr[] = q.poll();
            int cur = arr[0];
            int parent = arr[1];

            for(int child : edges.get(cur)){

                if(child == parent){
                    continue;
                }
                
                if(!visited[child]){
                    visited[child] = true;
                    q.add(new int[]{child,cur});
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }
    public boolean validTree(int n, int[][] edges) {

        int start = 0;
        boolean visited[] = new boolean[n];
        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        if(!dfs(0,graph,visited)){
            return false;
        }

        for(int i =0;i<n;i++){
            if(visited[i] == false){
                return false;
            }
        }

        return true;
    }
}
