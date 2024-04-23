class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> ans=new ArrayList<>();
        if(n==1 || n==2){
            for(int i=0;i<n;i++){
                ans.add(i);
            }
            return ans;
        }
        //array
        int[] degree=new int[n];
        List<List<Integer>> adj=new ArrayList<>();
               for(int i=0;i<n;i++){
               adj.add(new ArrayList<>()); 
            }
        
        for(int[] edge:edges){
            degree[edge[0]]++;
        adj.get(edge[0]).add(edge[1]);
        degree[edge[1]]++;
        adj.get(edge[1]).add(edge[0]);
    }
    //queue
    Queue<Integer> q =new LinkedList<>();
    for(int i=0;i<n;i++){
        if(degree[i]==1)q.add(i);
    }
    while(!q.isEmpty()){
        ans=new ArrayList<>();
    int size=q.size();
        for(int i=0;i<size;i++){
            int el=q.remove();
            ans.add(el);
            for(int nbr:adj.get(el)){
                degree[nbr]--;
                if(degree[nbr]==1)q.add(nbr);
            }
        }
    }
        return ans;
}
}

