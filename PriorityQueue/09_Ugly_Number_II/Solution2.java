// Time Complexity: O(nlogn), Space Complexity: O(n)

class Solution 2{
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> heap = new PriorityQueue<>();
        HashSet<Long> seen = new HashSet<>(); // avoid duplicates
        
        heap.add(1L); // 1L because it's "long integer"
        seen.add(1L);
        
        int[] factors = {2, 3, 5};
        
        long currentUgly = 1;
        
        for(int i=0 ; i<n ; i++){
            currentUgly = heap.poll(); // Get the smallest ugly number
            
            // Generate new ugly numbers and add them to the heap
            for (int factor : factors){
                long newUgly = currentUgly * factor;
                if (!seen.contains(newUgly)){
                    heap.add(newUgly);
                    seen.add(newUgly);
                }
            }
        }
        
        // After `n` iterations, `currentUgly` is the nth ugly number
        return (int)currentUgly;       
    }
}

/*

Example: n=8
Let’s walk through the process for n=8:

Start with heap = [1] and seen = {1}.
Extract 1, generate 2, 3, 5, add them:

heap = [2, 3, 5], seen = {1, 2, 3, 5}.
Extract 2, generate 4, 6, 10, add them:

heap = [3, 5, 4, 6, 10], seen = {1, 2, 3, 4, 5, 6, 10}.
Extract 3, generate 6, 9, 15, add them:

heap = [4, 5, 10, 6, 9, 15], seen = {1, 2, 3, 4, 5, 6, 9, 10, 15}.
Extract 4, generate 8, 12, 20, add them:

heap = [5, 6, 8, 15, 9, 10, 12, 20], seen = {1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, 20}.
Extract 5, generate 10, 15, 25, add them:

heap = [6, 9, 8, 15, 20, 10, 12, 25], seen = {1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, 20, 25}.
Extract 6, generate 12, 18, 30, add them:

heap = [8, 9, 10, 15, 20, 25, 12, 18, 30], seen = {1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, 18, 20, 25, 30}.
Extract 8: Stop (this is the 8th ugly number).

Final result: 8.
 */
