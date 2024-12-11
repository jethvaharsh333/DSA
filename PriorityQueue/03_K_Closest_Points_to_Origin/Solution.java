// Time Complexity: O(n.logk), Space Complexity: O(k)
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> 
            Double.compare(
                Math.sqrt(b[0]*b[0] + b[1]*b[1]), 
                Math.sqrt(a[0]*a[0] + a[1]*a[1])
            )
        );
        
        /**
            1] Min-heap
            PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);
            Comparator returns a negative value when the first argument is smaller.

            2] Max-heap
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
            Comparator returns a negative value when the first argument is larger.
        */

        for(int[] point : points){
            pq.offer(point);
            if(pq.size() > k){
                pq.poll();
            }
        }

        int[][] result = new int[k][2];
        int index = 0;
        while(!pq.isEmpty()){
            result[index++] = pq.poll();
        }

        return result;
    }
}
