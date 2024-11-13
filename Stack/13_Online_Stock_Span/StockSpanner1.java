// Time complexity: O(n); Space complexity: O(n)
class StockSpanner1 {
    Stack<int[]> stack;

    public StockSpanner1() {
        stack = new Stack<>();    
    }
    
    public int next(int price) {
        int span = 1;

        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            span += stack.pop()[1];
        }

        stack.push(new int[]{price, span});

        return span;
    }
}
