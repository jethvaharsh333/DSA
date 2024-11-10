// Time Complexity: O(n), Space Complexity: O(n)
class Solution1 {
    public int evalRPN(String[] tokens) {
        int ans = 0;
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for(String ch : tokens){
            if(ch.equals("+") || ch.equals("-") || ch.equals("*") || ch.equals("/")){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(evaluate(a,b,ch));  
            }else{
                stack.push(Integer.parseInt(ch));
            }
        }

        return stack.pop();
    }

    private int evaluate(int a, int b, String c){
        switch(c){
            case "+": return b+a;
            case "-": return b-a;
            case "*": return b*a;
            case "/": return b/a;
        }
        return -1;
    }
}
