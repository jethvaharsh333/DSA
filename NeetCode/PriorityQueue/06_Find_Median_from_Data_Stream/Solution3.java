// Time Complexity: addNum: O(logn); findMedian: O(1), Space Complexity: O(n)
class MedianFinder {
    private final PriorityQueue<Integer> maxHeap;
    private final PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        maxHeap = new PriorityQueue<>((a, b) -> b-a);
        minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(!maxHeap.isEmpty() && maxHeap.peek()>=num){
            maxHeap.offer(num);
        } 
        else{
            minHeap.offer(num);
        }

        if(maxHeap.size()-minHeap.size() == 2){
            minHeap.offer(maxHeap.poll());
        } 
        else if(minHeap.size()-maxHeap.size() == 2){
            maxHeap.offer(minHeap.poll());
        }
    }
    
    public double findMedian() {
        if(maxHeap.size() == minHeap.size()){
            return ((long)maxHeap.peek() + minHeap.peek()) / 2.0;
        } 
        else{
            return maxHeap.size()>minHeap.size() ? maxHeap.peek() : minHeap.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
