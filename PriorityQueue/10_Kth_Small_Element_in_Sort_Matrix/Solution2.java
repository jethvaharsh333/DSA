// Time Complexity: O(klogn), Space Complexity: O(n)

class Solution2 {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for(int i=0 ; i<n ; i++){
            minHeap.offer(new int[]{matrix[i][0], i, 0});
        }

        while(k > 1){
            int[] smallest = minHeap.poll();
            int row = smallest[1];
            int col = smallest[2];

            if(col+1 < n){
                minHeap.offer(new int[]{matrix[row][col+1], row, col+1});
            }

            k--;
        }

        return minHeap.poll()[0];
    }
}
