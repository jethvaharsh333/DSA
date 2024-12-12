// Time Complexity: addNum: O(n); findMedian: O(1), Space Complexity: O(n)
class MedianFinder {
    List<Integer> list;

    public MedianFinder() {
        list = new ArrayList<>();    
    }
    
    public void addNum(int num) {
        int pos = Collections.binarySearch(list, num);
        if(pos < 0){
            pos = -(pos + 1);
        }
        list.add(pos, num);
    }
    
    public double findMedian() {
        int size = list.size();
        if(size%2 == 0){
            double sum = list.get(size/2) + list.get((size/2)-1);
            return sum/2;
        }else{
            return list.get(size/2);
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
