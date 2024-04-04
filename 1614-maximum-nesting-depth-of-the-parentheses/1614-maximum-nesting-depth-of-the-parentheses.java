class Solution {
    public int maxDepth(String s) {
        int max=0;
        int openbrackets=0;
        for(char ch : s.toCharArray()){
            if(ch=='('){
                openbrackets++;
            }
            else if(ch==')'){
                openbrackets--;
                
            }
            max=Math.max(max,openbrackets);
        }
        return max;
        
    }
}
