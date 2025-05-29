// 10 ms

class Solution {
    public String removeOuterParentheses(String s) {
        Stack<Character> stack = new Stack<Character>();
        StringBuilder str = new StringBuilder();

        for(int i=0 ; i<s.length() ; i++){
            if(stack.isEmpty()){
                if(s.charAt(i) == '(') stack.push('(');
            }
            else{
                if(s.charAt(i) == '(') stack.push('(');    //if(s.charAt(i) == '(') stack.push(s.charAt(i)); also
                else{
                    if(stack.peek() == '(') stack.pop();
                    if(stack.isEmpty()) continue;
                }
                str.append(s.charAt(i));
            }
        }

        return str.toString();
    }
}
