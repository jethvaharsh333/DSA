class MyStack2 {
    private Queue<Integer> queue;

    public MyStack2() {
        queue = new LinkedList<Integer>();
    }
    
    public void push(int x) {
        queue.add(x);
        
        int size = queue.size();
        for (int i = 0; i < size - 1; i++) {
            queue.add(queue.remove());
        }
    }
    
    public int pop() {
        return queue.remove();
    }
    
    public int top() {
        return queue.peek();
    }
    
    public boolean empty() {
        return queue.isEmpty();
    }
}
