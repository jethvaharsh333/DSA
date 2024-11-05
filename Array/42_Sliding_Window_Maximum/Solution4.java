// Time complexity: O(n); Space Complexity: O(k); OPTIMAL SOLUTION
class Solution4 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>(); // doubly-ended queue

        for (int idx=0 ; idx<nums.length ; idx++) {
            int num = nums[idx];

            // Remove elements from the back of the deque if it is smaller than the current element `num`
            while(!deque.isEmpty() && deque.getLast() < num){
                deque.pollLast();
            }

            // Always adding the current element index to the back of the deque
            deque.addLast(num);

            // If the leftmost element in the deque is out of the current window, remove it
            if (idx >= k && nums[idx - k] == deque.getFirst()) {
                deque.pollFirst();
            }

            // Once we reach the end of the first window. add the maximum for the current window (front of the deque)
            if(idx >= k-1){
                res.add(deque.getFirst());
            }
        }

        return res.stream().mapToInt(i -> i).toArray();        
    }
}
