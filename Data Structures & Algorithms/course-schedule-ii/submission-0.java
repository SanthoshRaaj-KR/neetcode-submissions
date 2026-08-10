class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        List<List<Integer>> graph = new ArrayList<>();
        int indegree[] = new int[numCourses];

        for(int i =0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }

        for(int[] node : prerequisites){
            int current = node[1];
            int pre =  node[0];

            graph.get(pre).add(current);
            indegree[current]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i =0;i<numCourses;i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        int count = 0;
        ArrayList<Integer> temp = new ArrayList<>();

        while(!q.isEmpty()){

            int current = q.poll();
            count++;
            temp.add(current);

            for(int next: graph.get(current)){
                
                indegree[next]--;

                if(indegree[next] == 0){
                    q.add(next);
                }
            }
        }

        int ans[] = new int[numCourses];

        if(temp.size() < numCourses){
            return new int[]{};
        }
        
        Collections.reverse(temp);

        for(int i =0;i<numCourses;i++){
            ans[i] = temp.get(i);
        }

        return ans;
    }
}
