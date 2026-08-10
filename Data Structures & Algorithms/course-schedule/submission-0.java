class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

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

        while(!q.isEmpty()){

            int current = q.poll();
            count++;

            for(int next: graph.get(current)){
                
                indegree[next]--;

                if(indegree[next] == 0){
                    q.add(next);
                }
            }
        }

        return count == numCourses;
    }
}
