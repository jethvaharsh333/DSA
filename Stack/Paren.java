import java.util.Stack;

class Paren{
    public static void main(String[] args){
        String s = "{()}";

        isValid(s);
    }

    static void isValid(String s) {
        if(s.length%2 == 0){
            System.out.println("empty");
            return;
        }

        Stack<Character> stack = new Stack<>();

        for(int i=0 ; i<s.length() ; i++){
            System.out.println(s.charAt(i));
            char c = s.charAt(i);
            if(c == ('(' || '{' || '[')){
                stack.push(c);
            }
            else{
                if(c == ')' and stack.peek() == '('){
                    stack.pop();
                }
                else if(c == '}' and stack.peek() == '{'){
                    stack.pop();
                }
                else if(c == ']' and stack.peek() == '['){
                    stack.pop();
                }
            }
        } 

        if(stack.empty()){
            System.out.println("true");
        }


    }
}