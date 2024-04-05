class Solution {
    public String makeGood(String s) {
        char[] Stack=new char[s.length()];
        int top=-1;
        for(int i=0;i<s.length();i++){
            if(top>=0 && Math.abs(s.charAt(i)-Stack[top])==32){
                top--;
            }
            else{
                Stack[++top]=s.charAt(i);
            }
        }
        char[]ans=new char[top+1];
        while(top!=-1){
            ans[top]=Stack[top];
            top--;
        }
        return new String(ans);
        
    }
}