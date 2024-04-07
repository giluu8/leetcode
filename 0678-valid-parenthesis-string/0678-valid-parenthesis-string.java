class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> open,star;
        open=new Stack<>();
        star=new Stack<>();
         for(int i=0;i<s.length();i++){
             if(s.charAt(i)=='(')open.push(i);
             else if(s.charAt(i)=='*')star.push(i);
             else {
                 if(!open.isEmpty()) open.pop();
                 else if (!star.isEmpty()) star.pop();
                 else return false;
             }
         }
        while (open.size()!=0){
            if (star.size()==0) return false;
            if (star.peek()>open.peek()){
                star.pop();
                open.pop();
            }
            else {
                return false;
            }
        }
        return true;
    }
}