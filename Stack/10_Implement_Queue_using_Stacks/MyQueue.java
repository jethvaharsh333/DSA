class MyQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    
    public MyQueue() {
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }
    
    public void push(int x) {
        stack1.push(x);
    }
    
    public int pop() {
        int x = -1;
        while(!stack1.isEmpty()){
            x = stack1.pop();
            if(!stack1.isEmpty()) stack2.push(x);
        }

        while(!stack2.isEmpty()) stack1.push(stack2.pop());
        
        return x;
    }
    
    public int peek() {
        int x = -1;
        while(!stack1.isEmpty()){
            x = stack1.pop();
            stack2.push(x);
        }

        while(!stack2.isEmpty()) stack1.push(stack2.pop());

        return x;
    }
    
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
