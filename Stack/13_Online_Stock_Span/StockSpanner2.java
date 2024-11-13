// Time complexity: O(n); Space complexity: O(n) [EFFICIENT SOLUTION]
class Node {
    int price;
    int span;
    Node prev;
    
    Node(int price, int span) {
        this.price = price;
        this.span = span;
    }
}

class StockSpanner2 {
    private Node tail; 

    public StockSpanner() {
        tail = null;
    }

    public int next(int price) {
        int span = 1;
        while (tail != null && tail.price <= price) {
            span += tail.span;
            tail = tail.prev; 
        }

        Node newNode = new Node(price, span);
        newNode.prev = tail;
        tail = newNode;

        return span;
    }
}
