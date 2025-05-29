// Time Complexity: O(n^2 * logk), Space Complexity: O(k)

class Solution1 {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for(int i=0 ; i<matrix.length ; i++){
            for(int j=0; j<matrix[0].length ; j++){
                if(pq.size() < k){
                    pq.offer(matrix[i][j]);
                }
                else if(matrix[i][j] < pq.peek()){
                    pq.poll();
                    pq.offer(matrix[i][j]);
                }
            }
        }

        return pq.peek();
    }
}
