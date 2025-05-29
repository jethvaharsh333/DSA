// Time complexity: O(n^2); Space Complexity: O(1)
class Solution1 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n-k+1];

        for (int i=0 ; i<=n-k ; i++) {
            int max = Integer.MIN_VALUE;
            for (int j=i ; j<i+k ; j++) {
                max = Math.max(max, nums[j]);
            }
            result[i] = max;
        }

        return result;
    }
}
