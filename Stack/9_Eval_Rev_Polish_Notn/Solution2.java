class Solution2 {
    private String[] str;
    private int len;

    public int evalRPN(String[] tokens) {
        this.str = tokens;
        this.len = tokens.length-1;
        return eval();
    }

    private int eval(){
        String ch=str[len--];
        switch(ch){
            case "+": return eval()+eval();
            case "-": return -eval()+eval();
            case "*": return eval()*eval();
            case "/": int x=eval(); int y=eval(); return y/x;
            default: return Integer.valueOf(ch);
        }
    }
}
