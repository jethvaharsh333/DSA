// Time Complexity: addNum: O(logn); findMedian: O(1), Space Complexity: O(n)
class MedianFinder {
    private PriorityQueue<Integer> lowerHalf;
    private PriorityQueue<Integer> upperHalf;

    public MedianFinder() {
        lowerHalf = new PriorityQueue<>(Collections.reverseOrder()); // Max-heap
        upperHalf = new PriorityQueue<>(); // Min-heap    
    }
    
    public void addNum(int num) {
        // Add to the appropriate heap
        if(lowerHalf.isEmpty() || num<=lowerHalf.peek()){
            lowerHalf.offer(num);
        }
        else{
            upperHalf.offer(num);
        }

        // Balance the heaps if their sizes differ by more than 1
        if(lowerHalf.size() > upperHalf.size()+1){
            upperHalf.offer(lowerHalf.poll());
        } 
        else if(upperHalf.size() > lowerHalf.size()){
            lowerHalf.offer(upperHalf.poll());
        }
    }
    
    public double findMedian() {
        if(lowerHalf.size() > upperHalf.size()){
            return lowerHalf.peek();
        } 
        else if(upperHalf.size() > lowerHalf.size()){
            return upperHalf.peek();
        } 
        else{
            return (lowerHalf.peek() + upperHalf.peek()) / 2.0;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
