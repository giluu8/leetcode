class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character>Stack =new Stack<>();
        for(char ch:num.toCharArray()){
            while(!Stack.isEmpty() && k>0 && Stack.peek()>ch){
                Stack.pop();
                k--;
            }
            Stack.push(ch);
        }
        while(!Stack.isEmpty() && k>0){
            Stack.pop();
            k--;
        }
        StringBuilder sb=new StringBuilder();
        while(!Stack.isEmpty()){
            sb.append(Stack.pop());
        }
        sb.reverse();
while(sb.length() >1 && sb.charAt(0)=='0'){
    sb.deleteCharAt(0);
}
        return (sb.length()>0)?sb.toString():"0";
        
    }
}