// Time complexity: O(m+n), Space complexity: O(m+n)
class Solution1 {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();

        for(int i=0 ; i<s.length() ; i++){
            char ch = s.charAt(i);
            if(ch == '#'){
                if(!stack1.isEmpty()){
                    stack1.pop();
                }
            }
            else{
                stack1.push(ch);
            }
        }

        for(int j=0 ; j<t.length() ; j++){
            char ch = t.charAt(j);
            if(ch == '#'){
                if(!stack2.isEmpty()){
                    stack2.pop();
                }
            }
            else{
                stack2.push(ch);
            }
        }

        if(stack1.equals(stack2)) return true;
        return false;
    }
}
