class Solution {
    public int openLock(String[] deadends, String target) {
        HashSet<String> deadEnds=new HashSet<>(Arrays.asList(deadends));
    HashSet<String>visited=new HashSet<>();
    Queue<String>queue=new LinkedList<>();
    queue.add("0000");
    int moves=0;
    while (!queue.isEmpty()){
        int size=queue.size();
        while(size!=0){
            String currentPosition=queue.poll();
if(deadEnds.contains(currentPosition)||visited.contains(currentPosition)){
    size--;
    continue;
}
            visited.add(currentPosition);
            if(currentPosition.equals(target))return moves;
            StringBuilder sb=new StringBuilder(currentPosition);
            for(int i=0;i<4;i++){
                char wheelValue=sb.charAt(i);
                String s1=sb.substring(0,i)+(wheelValue=='9'?0:wheelValue-'0'+1)+sb.substring(i+1);
                  String s2=sb.substring(0,i)+(wheelValue=='0'?9:wheelValue-'0'-1)+sb.substring(i+1);
                if(!visited.contains(s1)&& !deadEnds.contains(s1)){
                    queue.add(s1);
                }
                if(!visited.contains(s2)&& !deadEnds.contains(s2)){
                    queue.add(s2);
                }
                
            }
            size--;
        }
        moves++;
    }
    return -1;
        
        
    }
}