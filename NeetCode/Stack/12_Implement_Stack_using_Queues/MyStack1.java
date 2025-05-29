class MyStack1 {
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    public MyStack1() {
        queue1 = new LinkedList<Integer>();
        queue2 = new LinkedList<Integer>();
    }
    
    public void push(int x) {
        queue1.add(x);
    }
    
    public int pop() {
        int x = -1;
        while(!queue1.isEmpty()){
            x = queue1.remove();
            if(!queue1.isEmpty()){
                queue2.add(x);
            }
        }

        while(!queue2.isEmpty()){
            queue1.add(queue2.remove());
        }

        return x;
    }
    
    public int top() {
        while(!queue1.isEmpty()){
            queue2.add(queue1.remove());
        }

        int x = -1;

        while(!queue2.isEmpty()){
            x = queue2.remove();
            queue1.add(x);
        }

        return x;
    }
    
    public boolean empty() {
        return queue1.isEmpty();
    }
}

/**
 * Your MyStack1 object will be instantiated and called as such:
 * MyStack1 obj = new MyStack1();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
