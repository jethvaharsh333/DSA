// Time complexity: O(n.logk); Space complexity: O(k) [Adding an element: Time Complexity: O(logk)]

class KthLargest {
    private PriorityQueue<Integer> pq;
    private int k;

    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<Integer>();
        this.k = k;

        for(int x: nums){
            add(x);
        }
    }
    
    public int add(int val) {
        if(pq.size() < k){
            pq.offer(val);
        }
        else if(val > pq.peek()){
            pq.poll();
            pq.offer(val);
        }

        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
